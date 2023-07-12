package com.tintandtone.service;

import com.tintandtone.model.Image;

import java.io.IOException;

public interface ImageUploadService {

    void uploadImage(Image image) throws IOException;
}
