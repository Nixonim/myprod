package service;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import util.PropertiesUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

@NoArgsConstructor
public class ImageService {
    private static ImageService imageService = new ImageService();
    private final String baseUrl = PropertiesUtil.get("urlImage.base");

    public static ImageService getImageService() {
        return imageService;
    }

    public void upload(String imagePath, InputStream imageStream) {
        var imageFullPath = Path.of(baseUrl, imagePath);

        try (imageStream) {
            Files.createDirectories(imageFullPath.getParent());
            System.out.println(imageFullPath);
            Files.write(imageFullPath,imageStream.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public Optional<InputStream> get(String inputPath) {
        var fullPath = Path.of(baseUrl, inputPath);
        System.out.println(fullPath);
        return Files.exists(fullPath)?
                Optional.of(Files.newInputStream(fullPath)):
                Optional.empty();
    }
}
