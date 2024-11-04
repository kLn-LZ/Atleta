package br.edu.fateczl.atleta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.edu.fateczl.atleta.controller.IOperacao;
import br.edu.fateczl.atleta.controller.OperacaoJuvenil;
import br.edu.fateczl.atleta.controller.OperacaoSenior;
import br.edu.fateczl.atleta.model.AtletaJuvenil;
import br.edu.fateczl.atleta.model.AtletaSenior;

public class SeniorFragment extends Fragment {

    /*
     *@author: Kelvin Santos Guimarães
     */

    private View view;
    private EditText etNomeSenior;
    private EditText etDataNascimentoSenior;
    private EditText etBairroSenior;
    private EditText etQtdAnoPraticaEsporteSenior;
    private CheckBox cbTemProblemaCardiacoSenior;
    private Button btnCadastrarSenior;
    private TextView tvListaSenior;

    public SeniorFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_senior, container, false);
        etNomeSenior = view.findViewById(R.id.etNomeSenior);
        etDataNascimentoSenior = view.findViewById(R.id.etDataNascimentoSenior);
        etBairroSenior = view.findViewById(R.id.etBairroSenior);
        cbTemProblemaCardiacoSenior = view.findViewById(R.id.cbTemProblemaCardiacoSenior);
        btnCadastrarSenior = view.findViewById(R.id.btnCadastrarSenior);
        tvListaSenior = view.findViewById(R.id.tvListaSenior);
        tvListaSenior.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCadastrarSenior.setOnClickListener(op -> {
            try {
                cadastro();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        return view;
    }

    private void cadastro() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Date data = formato.parse(etDataNascimentoSenior.getText().toString());

        AtletaSenior as = new AtletaSenior();
        as.setNome(etNomeSenior.getText().toString());
        as.setBairro(etBairroSenior.getText().toString());
        as.setDataNascimento(data);
        as.setTemProblemaCardiaco(cbTemProblemaCardiacoSenior.isChecked());
        IOperacao op = new OperacaoSenior();
        op.cadastrar(as);
        List<AtletaSenior> lista = op.listar();

        StringBuffer buffer = new StringBuffer();
        for (AtletaSenior a: lista) {
            buffer.append(a.toString() + "\n");
        }
        tvListaSenior.setText(buffer.toString());
        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();
        limpaCampos();
    }

    private void limpaCampos() {
        etNomeSenior.setText("");
        etBairroSenior.setText("");
        etDataNascimentoSenior.setText("");
        cbTemProblemaCardiacoSenior.setChecked(false);
    }
}