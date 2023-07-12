package com.tintandtone.controller;

import com.tintandtone.model.Image;
import com.tintandtone.service.ImageUploadService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

@Path("/upload")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ImageUploadController {

    @Inject
    ImageUploadService imageUploadService;

    @POST
    public Response uploadImage(Image image) {
        try {
            imageUploadService.uploadImage(image);
            return Response.ok().build();
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
