public class Polynomial {
    double[] coefficients;

    public Polynomial() {
        coefficients = new double[1];
        coefficients[0] = 0;
    }

    public Polynomial(double[] coefficients_) {
        int len = coefficients_.length;
        coefficients = new double[len];
        for (int i = 0; i < len; i++) {
            coefficients[i] = coefficients_[i];
        }
    }

    public Polynomial add(Polynomial p) {
        int min_len;
        int max_len;
        boolean is_this_longer;

        if (p.coefficients.length < this.coefficients.length) {
            min_len = p.coefficients.length;
            max_len = this.coefficients.length;
            is_this_longer = true;
        }
        else {
            min_len = this.coefficients.length;
            max_len = p.coefficients.length;
            is_this_longer = false;
        }

        double[] out = new double[max_len];

        for (int i = 0; i < max_len; i++) {
            if (i < min_len) out[i] = this.coefficients[i] + p.coefficients[i];
            else {
                if (is_this_longer) out[i] = this.coefficients[i];
                else out[i] = p.coefficients[i];
            }
        }

        Polynomial sum = new Polynomial(out);

        return sum;
    }

    public double evaluate(double x) {
        double out = 0;

        for (int i = 0; i < this.coefficients.length; i++) {
            out += this.coefficients[i] * (Math.pow(x, i));
        }

        return  out;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0;
    }
}