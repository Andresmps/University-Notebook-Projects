#!/usr/bin/env python
# coding: utf-8


import matplotlib.pyplot as plt
import numpy as np
import scipy
import cv2
import pylab
from scipy import misc
from skimage.feature import local_binary_pattern
from skimage.feature import canny
from skimage import io
from skimage import color
from skimage.transform import rescale, resize, downscale_local_mean
from scipy.spatial import distance


def convert_to_gray(img):
    r, g, b = img[:,:,0], img[:,:,1], img[:,:,2]
    img_gray = (0.2989 * r) + (0.5870 * g) + (0.1140 * b)
    return img_gray


def plot_img_gray(img):

    fig, axes = plt.subplots(1, 2,  figsize=(15, 4))

    axes[0].imshow(convert_to_gray(img), cmap = plt.get_cmap('gray'))
    axes[1].hist(convert_to_gray(img).ravel(), bins='auto', color="gray", label='Grays Histogram')  # arguments are passed to np.histogram
    axes[1].legend()
    
    return convert_to_gray(img)

    
def plot_img_r(img):

    fig, axes = plt.subplots(1, 2,  figsize=(15, 4))

    r = np.copy(img)
    r[:,:,1], r[:,:,2] = 0, 0
    axes[0].imshow(r, cmap = plt.get_cmap('Reds'))
    axes[1].hist(img[:,:,0].ravel(), bins='auto', color="red", label='Reds Histogram')  # arguments are passed to np.histogram
    axes[1].legend()
    
    return img[:,:,0]
    

def plot_img_g(img):

    fig, axes = plt.subplots(1, 2,  figsize=(15, 4))
    
    g = np.copy(img)
    g[:,:,0], g[:,:,2] = 0, 0
    axes[0].imshow(g, cmap = plt.get_cmap('Greens'))
    axes[1].hist(img[:,:,1].ravel(), bins='auto', color="green", label='Greens Histogram')  # arguments are passed to np.histogram
    axes[1].legend()  
    
    return img[:,:,1]


def plot_img_b(img):

    fig, axes = plt.subplots(1, 2,  figsize=(15, 4))
    
    b = np.copy(img)
    b[:,:,0], b[:,:,1] = 0, 0
    axes[0].imshow(b, cmap = plt.get_cmap('Blues'))
    axes[1].hist(img[:,:,2].ravel(), bins='auto', color="blue", label='Blues Histogram')  # arguments are passed to np.histogram
    axes[1].legend()  
    
    return img[:,:,2]


def plot_texture(img):
    
    fig, axes = plt.subplots(1, 2,  figsize=(15, 4))

    radius = 3
    n_points = 8 * radius
    METHOD = 'default'
    
    lbp = local_binary_pattern(convert_to_gray(img), n_points, radius, METHOD)
    lbp = (lbp - lbp.min())/(lbp.max() - lbp.min()) 

    axes[0].imshow(lbp,cmap = plt.get_cmap('gray'))
    axes[1].hist(lbp.ravel(), bins='auto', color="black", label ='Texture Histogram')  # arguments are passed to np.histogram
    axes[1].legend()
    
    return lbp
    
    
def plot_borders(img):
    
    fig, axes = plt.subplots(1, 2,  figsize=(15, 4))

    dx = scipy.ndimage.sobel(convert_to_gray(img), 0)  # derivada horizontal
    dy = scipy.ndimage.sobel(convert_to_gray(img), 1)  # derivada vertical
    
    mag = np.hypot(dx, dy) * 255.0  # magnitud
    mag *= 255.0 / np.max(mag)  # normalización
    
    axes[0].imshow(mag, cmap = plt.get_cmap('gray'))
    axes[1].hist(mag.ravel(), bins='auto', color="black", label='Borders Histogram')  # arguments are passed to np.histogram
    axes[1].legend()
    
    return mag


def plot_distance(images, hists, metric, index, names):
    results = {}
    
    for (k, hist) in enumerate(hists):
        distance = metric[1](hists[index], hist)
        results[k] = distance

    results = sorted([(v, k) for (k, v) in results.items()])
    
    fig, axis = plt.subplots(1, 4,  figsize=(15, 3))
    axis[0].set_title('Image: {} | Metric: {} '.format(names[index], metric[0]))
    axis[0].imshow(images[index])
    
    
    for (i, (v, k)) in enumerate(results):
        axis[i+1].set_title("{} : {:.2f}".format(names[k], v))
        axis[i+1].imshow(images[k])
    plt.show()
    
    
def plot_relation(images, hists, method, index, names):
    results = {}
    
    for (k, hist) in enumerate(hists):
        relation = cv2.compareHist(np.float32(hists[index]), np.float32(hist), method[1])
        results[k] = relation

    results = sorted([(v, k) for (k, v) in results.items()])
    
    fig, axis = plt.subplots(1, 4,  figsize=(15, 3))
    axis[0].set_title('Image: {} | Metric: {} '.format(names[index], method[0]))
    axis[0].imshow(images[index])
    
    
    for (i, (v, k)) in enumerate(results):
        axis[i+1].set_title("{} : {:.2f}".format(names[k], abs(v)))
        axis[i+1].imshow(images[k])
    plt.show()



