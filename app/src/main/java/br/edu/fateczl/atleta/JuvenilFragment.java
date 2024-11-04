package br.edu.fateczl.atleta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import br.edu.fateczl.atleta.controller.IOperacao;
import br.edu.fateczl.atleta.controller.OperacaoJuvenil;
import br.edu.fateczl.atleta.model.AtletaJuvenil;

public class JuvenilFragment extends Fragment {

    /*
     *@author: Kelvin Santos Guimarães
     */

    private View view;
    private EditText etNomeJuvenil;
    private EditText etDataNascimentoJuvenil;
    private EditText etBairroJuvenil;
    private EditText etQtdAnoPraticaEsporteJuvenil;
    private Button btnCadastrarJuvenil;
    private TextView tvListaJuvenil;


    public JuvenilFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_juvenil, container, false);
        etNomeJuvenil = view.findViewById(R.id.etNomeJuvenil);
        etDataNascimentoJuvenil = view.findViewById(R.id.etDataNascimentoJuvenil);
        etBairroJuvenil = view.findViewById(R.id.etBairroJuvenil);
        etQtdAnoPraticaEsporteJuvenil = view.findViewById(R.id.etQtdAnoPraticaEsporteJuvenil);
        btnCadastrarJuvenil = view.findViewById(R.id.btnCadastrarJuvenil);
        tvListaJuvenil = view.findViewById(R.id.tvListaJuvenil);
        tvListaJuvenil.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCadastrarJuvenil.setOnClickListener(op -> {
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

        Date data = formato.parse(etDataNascimentoJuvenil.getText().toString());

        AtletaJuvenil aj = new AtletaJuvenil();
        aj.setNome(etNomeJuvenil.getText().toString());
        aj.setBairro(etBairroJuvenil.getText().toString());
        aj.setDataNascimento(data);
        aj.setQtdAnoPraticaEsporte(Integer.parseInt(etQtdAnoPraticaEsporteJuvenil.getText().toString()));

        IOperacao op = new OperacaoJuvenil();
        op.cadastrar(aj);
        List<AtletaJuvenil> lista = op.listar();

        StringBuffer buffer = new StringBuffer();
        for (AtletaJuvenil a: lista) {
            buffer.append(a.toString() + "\n");
        }
        tvListaJuvenil.setText(buffer.toString());
        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();
        limpaCampos();
    }

    private void limpaCampos() {
        etNomeJuvenil.setText("");
        etBairroJuvenil.setText("");
        etDataNascimentoJuvenil.setText("");
        etQtdAnoPraticaEsporteJuvenil.setText("");
    }
}