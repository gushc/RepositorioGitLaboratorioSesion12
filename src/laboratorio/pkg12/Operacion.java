package laboratorio.pkg12;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Operacion {
    private float valor1;
    private float valor2;
    private JLabel lblError1;
    private JLabel lblError2;
    private JLabel lblError3;

    public Operacion() {}

    public Operacion(float valor1, float valor2, JLabel lblError1, JLabel lblError2, JLabel lblError3) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.lblError1 = lblError1;
        this.lblError2 = lblError2;
        this.lblError3 = lblError3;
    }

    public void setValorDe1DesdeCaja(JTextField caja) {
        this.valor1 = getNumero(caja, lblError1);
    }

    public void setValorDe2DesdeCaja(JTextField caja) {
        this.valor2 = getNumero(caja, lblError2);
    }

    private float getNumero(JTextField caja, JLabel labelError) {
        String num = caja.getText();
        try {
            return Float.parseFloat(num);
        } catch (NumberFormatException ex) {
            labelError.setText("Número Inválido");
            return 0f;
        }
    }

    public void realizarSuma(JTextField cajaResultado) {
        float resultado = valor1 + valor2;
        cajaResultado.setText(String.valueOf(resultado));
    }

    public void realizarResta(JTextField cajaResultado) {
        float resultado = valor1 - valor2;
        cajaResultado.setText(String.valueOf(resultado));
    }

    public void realizarMultiplicacion(JTextField cajaResultado) {
        float resultado = valor1 * valor2;
        cajaResultado.setText(String.valueOf(resultado));
    }

    public void realizarDivision(JTextField cajaResultado) {
        try {
            if (valor2 != 0) {
                float resultado = valor1 / valor2;
                cajaResultado.setText(String.valueOf(resultado));
                lblError3.setText("");
            } else {
                throw new ArithmeticException("No se puede dividir entre cero");
            }
        } catch (ArithmeticException ex) {
            lblError3.setText(ex.getMessage());
            cajaResultado.setText("");
        }
    }
}
