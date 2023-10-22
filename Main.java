import java.util.Scanner;
// Создаем интерфейс
interface ImageViewer {
    void view(String imageType, String fileName);
}
// Создаем первый адаптируемый обьект (Adaptee)
class JpegViewer {
    void viewJpeg(String fileName) {
        System.out.println("Viewing JPEG image: " + fileName);
    }
}
// Создаем второй адаптируемый обьект (Adaptee)
class PngViewer {
    void viewPng(String fileName) {
        System.out.println("Viewing PNG image: " + fileName);
    }
}
// Класс который реализует интерфейс.
class ImageAdapter implements ImageViewer {
    private JpegViewer jpegViewer;
    private PngViewer pngViewer;

    public ImageAdapter(JpegViewer jpegViewer, PngViewer pngViewer) {
        this.jpegViewer = jpegViewer;
        this.pngViewer = pngViewer;
    }

    @Override
    public void view(String imageType, String fileName) {
        if (imageType.equalsIgnoreCase("jpeg")) {
            jpegViewer.viewJpeg(fileName);
        } else if (imageType.equalsIgnoreCase("png")) {
            pngViewer.viewPng(fileName);
        } else {
            System.out.println("Unsupported image type: " + imageType);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        JpegViewer jpegViewer = new JpegViewer();
        PngViewer pngViewer = new PngViewer();
        ImageAdapter imageAdapter = new ImageAdapter(jpegViewer, pngViewer);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter image type (jpeg or png): ");
            String imageType = scanner.nextLine();
            if (imageType.isEmpty()) {
                break;
            }

            System.out.print("Enter file name: ");
            String fileName = scanner.nextLine();

            imageAdapter.view(imageType, fileName);
        }

        scanner.close();
    }
}
