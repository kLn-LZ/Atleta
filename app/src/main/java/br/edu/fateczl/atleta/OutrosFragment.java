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
import java.util.Date;
import java.util.List;

import br.edu.fateczl.atleta.controller.IOperacao;
import br.edu.fateczl.atleta.controller.OperacaoOutros;
import br.edu.fateczl.atleta.controller.OperacaoSenior;
import br.edu.fateczl.atleta.model.AtletaOutros;
import br.edu.fateczl.atleta.model.AtletaSenior;

public class OutrosFragment extends Fragment {

    /*
     *@author: Kelvin Santos Guimarães
     */

    private View view;
    private EditText etNomeOutros;
    private EditText etDataNascimentoOutros;
    private EditText etBairroOutros;
    private EditText etAcademiaOutros;
    private EditText etRecordeOutros;
    private Button btnCadastrarOutros;
    private TextView tvListaOutros;

    public OutrosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_outros, container, false);

        etNomeOutros = view.findViewById(R.id.etNomeOutros);
        etDataNascimentoOutros = view.findViewById(R.id.etDataNascimentoOutros);
        etBairroOutros = view.findViewById(R.id.etBairroOutros);
        etAcademiaOutros = view.findViewById(R.id.etAcademiaOutros);
        etRecordeOutros = view.findViewById(R.id.etRecordeOutros);
        btnCadastrarOutros = view.findViewById(R.id.btnCadastrarOutros);
        tvListaOutros = view.findViewById(R.id.tvListaOutros);
        tvListaOutros.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCadastrarOutros.setOnClickListener(op -> {
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

        Date data = formato.parse(etDataNascimentoOutros.getText().toString());

        AtletaOutros ao = new AtletaOutros();
        ao.setNome(etNomeOutros.getText().toString());
        ao.setBairro(etBairroOutros.getText().toString());
        ao.setDataNascimento(data);
        ao.setAcademia(etAcademiaOutros.getText().toString());
        ao.setRecorde(Double.valueOf(etRecordeOutros.getText().toString()));
        IOperacao op = new OperacaoOutros();
        op.cadastrar(ao);
        List<AtletaOutros> lista = op.listar();

        StringBuffer buffer = new StringBuffer();
        for (AtletaOutros a: lista) {
            buffer.append(a.toString() + "\n");
        }
        tvListaOutros.setText(buffer.toString());
        Toast.makeText(view.getContext(), buffer.toString(), Toast.LENGTH_LONG).show();
        limpaCampos();
    }

    private void limpaCampos() {
        etNomeOutros.setText("");
        etBairroOutros.setText("");
        etDataNascimentoOutros.setText("");
        etAcademiaOutros.setText("");
        etRecordeOutros.setText("");
    }
}