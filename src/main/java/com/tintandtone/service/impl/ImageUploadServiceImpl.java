package com.tintandtone.service.impl;

import com.tintandtone.model.Image;
import com.tintandtone.service.ImageUploadService;
import jakarta.enterprise.context.ApplicationScoped;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;
import java.nio.ByteBuffer;

@ApplicationScoped
public class ImageUploadServiceImpl implements ImageUploadService {
    private static final String BUCKET_NAME = "tintandtone-photo-dataset";

    @Override
    public void uploadImage(Image image) throws IOException {
        S3Client s3Client = S3Client.builder().build();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .key(image.getName())
                .contentType(image.getContentType())
                .build();

        try {
            PutObjectResponse response = s3Client.putObject(request, RequestBody.fromByteBuffer(ByteBuffer.wrap(image.getData())));
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Failed to upload image to S3 bucket.");
        } finally {
            s3Client.close();
        }
    }
}
