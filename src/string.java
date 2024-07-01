import java.util.Scanner;

public class string {
    public static void ChuanHoa() {
        Scanner scanner = new Scanner(System.in);

        // Nhập chuỗi từ bàn phím
        System.out.print("Nhập chuỗi: ");
        String input = scanner.nextLine();

        // Bước 1: Loại bỏ khoảng trắng đầu và cuối chuỗi
        String trimmedString = input.trim();

        // Bước 2: Thay thế nhiều khoảng trắng liên tiếp bằng một khoảng trắng
        String normalizedString = trimmedString.replaceAll("\\s+", " ");

        // Bước 3: Viết hoa chữ cái đầu của mỗi từ, các chữ cái còn lại viết thường
        String[] words = normalizedString.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                // Viết hoa chữ cái đầu và các chữ còn lại viết thường
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        // Loại bỏ khoảng trắng cuối cùng sau khi ghép chuỗi
        String finalString = result.toString().trim();

        // In chuỗi đã được chuẩn hóa
        System.out.println("Chuỗi sau khi chuẩn hóa: " + finalString);


        scanner.close();
    }

}
