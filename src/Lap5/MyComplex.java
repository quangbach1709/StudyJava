package Lap5;

public class MyComplex {
    private double real;
    private double imag;

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "MyComplex{" +
                "real=" + real +
                ", imag=" + imag +
                '}';
    }

    public boolean isReal() {
        return imag == 0; //kiem tra so phuc co phan thuc hay khong
    }

    public boolean isImaginary() {
        return real == 0; //kiem tra so phuc co phan ao hay khong
    }

    public boolean equals(double real, double imag) {
        return this.real == real && this.imag == imag; //so sanh 2 so phuc
    }

    public boolean equals(MyComplex another) {
        return this.real == another.real && this.imag == another.imag; //so sanh 2 so phuc
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2)); //tinh do lon cua so phuc
    }

    public int argumentInDegrees() {
        return (int) Math.toDegrees(Math.atan2(imag, real)); //tinh goc cua so phuc
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -imag); //tim so phuc nghich dao
    }

    public MyComplex add(MyComplex right) {
        return new MyComplex(real + right.real, imag + right.imag); //cong 2 so phuc
    }

    public MyComplex subtract(MyComplex right) {
        return new MyComplex(real - right.real, imag - right.imag); //tru 2 so phuc
    }

    //tinh tich 2 so phuc
    public MyComplex multiply(MyComplex right) {
        return new MyComplex(real * right.real - imag * right.imag, real * right.imag + imag * right.real);
    }

    //tinh thuong 2 so phuc
    public MyComplex divide(MyComplex right) {
        double denominator = Math.pow(right.real, 2) + Math.pow(right.imag, 2);
        return new MyComplex((real * right.real + imag * right.imag) / denominator, (imag * right.real - real * right.imag) / denominator);
    }
}
