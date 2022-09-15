package mb.livedatabase1;
import android.os.Handler;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;

public class DogRepository implements DogApi {
    //Atributos
    public static DogRepository instance;

    //Instancia
    public static DogRepository getInstance(){
        if(instance == null){ instance = new DogRepository(); }
        return instance;
    }

    //LiveData
    @Override public MutableLiveData<DogModel> findById(int id) {
        DogModel dogModel                     = new DogModel(id, "Merge",  R.drawable.marge);
        MutableLiveData<DogModel> dogModel_LD = new MutableLiveData<>();

        new Handler().postDelayed(new Runnable() { @Override public void run() {
            dogModel_LD.postValue(dogModel);
        }}, 4000);

        return dogModel_LD;
    }

    @Override public MutableLiveData<List<DogModel>> findAll() {
        List<DogModel> listaDogs                     = new ArrayList<>();
        MutableLiveData<List<DogModel>> listaDogs_LD = new MutableLiveData<>();

        new Handler().postDelayed(new Runnable() { @Override public void run() {
            listaDogs.add(new DogModel(1, "Marcelo", R.drawable.bart));
            listaDogs.add(new DogModel(2, "Daniel",  R.drawable.homer));

            listaDogs_LD.postValue(listaDogs);
        }}, 4000);

        return listaDogs_LD;
    }
}

