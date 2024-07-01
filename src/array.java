import java.util.Scanner;

public class array {
    public static void Bai1() {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println("Nhap so phan tu cua mang: ");
            n = scanner.nextInt();
        }
        while (n < 0 || n > 10);
        int[] arr = new int[n];
        System.out.println("Nhap cac phan tu cua mang: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhap phan tu thu" + (i + 1));
            arr[i] = scanner.nextInt();
        }
        int x;
        do {
            System.out.println("Nhap so x: ");
            x = scanner.nextInt();
        }
        while (x < 0);
        int[] newArr = new int[n + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i == newArr.length - 1) {
                newArr[i] = x;
            } else
                newArr[i] = arr[i];
        }

        System.out.println("Cac gia tri cua mang la: ");
        for (int index : newArr) {
            System.out.print(index + " ");
        }
        scanner.close();
    }

    public static void Bai2() {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println("Nhap so phan tu cua mang:");
            n = scanner.nextInt();
        }
        while (n < 0 || n > 10);
        System.out.println("Nhap cac phan tu cua mang: ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhap phan tu thu " + (i + 1));
            arr[i] = scanner.nextInt();
        }
        int x;
        do {
            System.out.println("Nhap so x: ");
            x = scanner.nextInt();
        } while (x >= 0 || x <= n);
        int[] newArr = new int[n - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i != x) {
                newArr[i] = arr[i];
            }
        }
        System.out.println("Mang sau khi xoa pha tu o vi tri " + x + " la:");
        for (int index : newArr) {
            System.out.print(index + " ");
        }
        scanner.close();
    }

    public static void Bai3() {
        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.println("Nhap so phan tu cua mang:");
            n = scanner.nextInt();
        } while (n < 0 || n > 10);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Nhap phan tu thu " + (i + 1));
            arr[i] = scanner.nextInt();
        }
        int x, y;
        do {
            System.out.println("Nhap gia tri vi tri x:");
            x = scanner.nextInt();

        } while (x < 0 || x > n);
        int[] newArr = new int[n + 1];
        System.out.println("Nhap gia tri so y:");
        y = scanner.nextInt();
        for (int i = 0; i < x; i++) {
            newArr[i] = arr[i];
        }
        newArr[x] = y;
        for (int i = x; i < n; i++) {
            newArr[i + 1] = arr[i];
        }
        System.out.println("Mang sau khi them y la:");
        for (int index : newArr) {
            System.out.print(index + " ");
        }
        scanner.close();
    }

    //Mang 2 chieu
    public static void Bai4() {
        Scanner scanner = new Scanner(System.in);

        int n, m;
        do {
            System.out.print("n= ");
            n = scanner.nextInt();
        } while (n > 0 || n < 10);
        do {
            System.out.print("m= ");
            m = scanner.nextInt();
        } while (m > 0 || m < 10);

        int[][] arr = new int[n][m];
        int sum = 0;
        System.out.println("Nhap mang:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
                sum += arr[i][j];
            }
        }
        System.out.println("Tong cac phan tu trong array la: " + sum);
        scanner.close();

    }

    //    In ra cac phan tu lon nhat cua cac hang
    public static void Bai5() {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        do {
            System.out.print("n= ");
            n = scanner.nextInt();
        } while (n < 0 || n > 10);
        do {
            System.out.print("m= ");
            m = scanner.nextInt();
        } while (m < 0 || m > 10);

        int[][] arr = new int[n][m];
        System.out.println("Nhap mang:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.print("Cac phan tu lon nhat la: ");
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            System.out.print(max + " ");
            max = 0;
        }

        scanner.close();
    }

    //    Tong cac gia tri bien
    public static void Bai6() {
        Scanner scanner = new Scanner(System.in);

        int n, m;
        do {
            System.out.print("n= ");
            n = scanner.nextInt();
        } while (n < 0 || n > 10);
        do {
            System.out.print("m= ");
            m = scanner.nextInt();
        } while (m < 0 || m > 10);

        int[][] arr = new int[n][m];
        System.out.println("Nhap Mang:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.print("Tong cac gia tri bien la: ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1) || (j == 0 || j == m - 1)) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.print(sum);

        scanner.close();
    }
}
