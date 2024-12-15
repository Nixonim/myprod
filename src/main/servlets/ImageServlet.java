package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import service.ImageService;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    ImageService imageService = ImageService.getImageService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String imagePath = requestURI.replace("/images", "");


        imageService.get(imagePath).ifPresentOrElse(
                image -> {
                    resp.setContentType("application/octet-stream");
                    writer(image,resp);
                }, () -> resp.setStatus(404));
    }

    private void writer(InputStream image, HttpServletResponse resp) {
        try (image;
       var writer = resp.getOutputStream()){
        int current;
        while ((current = image.read()) != -1) {
            writer.write(current);
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
