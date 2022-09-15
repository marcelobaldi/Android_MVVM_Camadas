package mb.livedatabase1;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import mb.livedatabase1.databinding.ActivityDogBinding;

public class DogActivity extends AppCompatActivity {
    //Atributos
    private ActivityDogBinding binding;
    private DogViewModel       dogViewModel;

    //Método Inicial
    @Override protected void onCreate(Bundle savedInstanceState){super.onCreate(savedInstanceState);
        //Binding e ViewModel
        binding      = DataBindingUtil.setContentView(this, R.layout.activity_dog);
        dogViewModel = new ViewModelProvider(this).get(DogViewModel.class);

        //Carregamento Inicial  (Setter's e Load's)
        dogViewModel.setTitulo();

        //Listener's            (Getter's)
        observer();
    }

    //Listener's
    public void observer(){
        dogViewModel.getTitulo().observe(this, new Observer<String>() {
        @Override public void onChanged(String sX) {
            binding.dogTxtTitulo.setText(sX);
        }});

        dogViewModel.getDog().observe(this, new Observer<DogModel>() {
        @Override public void onChanged(DogModel dogModelX) {
            binding.dogTxtNumerodigitado.setText(String.valueOf(dogModelX.getId()));
            Log.d("myLog", dogModelX.toString());
        }});

        dogViewModel.getListaDogs().observe(this, new Observer<List<DogModel>>() {
        @Override public void onChanged(List<DogModel> dogModelsV) {
            Log.d("myLog", dogModelsV.toString());
        }});
    }

    //Eventos
    public void dog_btn_pegardados(View view){
        String idS = binding.dogEdtNumeroid.getText().toString();
        int    id  = Integer.parseInt(idS);
        dogViewModel.setDog(id, this);
    }
    public void dog_btn_lista(View view){ dogViewModel.loadListaDogs(this); }
}

//Dúvidas - Gerais
//- Variáveis:      Nem as das Camadas como Atributos de Classe? Ex: A Business usada na ViewModel.
//- Classes:        Instanciar com New ou GetInstance?

//Dúvidas - Estrutura
//- API:            Serviços;
//- Model:          Objeto Manipulado;
//- Repository:     Retorno dos Serviços;
//- Business:       Manipulação do Retorno dos Serviços;
//- ViewModel:      GetterSetter da View e Camada Intermediária Entre View x Business;
//- View:           Tela (Pega e Exibe Objetos);

////////////////////////////////////////////////////////////////////////////////////////////////////

//MVVM - Variáveis
//- Local:          ViewModel (Atributo Classe)  e  Outras  (No Escopo);
//- Instancia:      LiveData  (LiveData)         e  Normais (Conforme Objeto);

//MVVM - Contexto
//- P/ ViewModel:   Não Passar ao Instanciar a Classe. Passar No Respectivo Método Que Chama;
//- P/ Adapter:     Não Passar. Pegar Nos Respectivos Métodos do Adapter;

////////////////////////////////////////////////////////////////////////////////////////////////////

//Projeto Next
//- Anotações:      Evitar Anotações;
//- This:           Utilizar, Exceto Se Obrigar o NomeActivity+This (Dentro de Outro Escopo);
//- Lambda:         Utilizar;


