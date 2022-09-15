package mb.livedatabase1;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.List;

public class DogBusiness {
    //Atributos
    //...

    //LiveData
    public MutableLiveData<DogModel> dog (int id, LifecycleOwner lo){
        MutableLiveData<DogModel> dogModel_LD   = new MutableLiveData<>();

        DogRepository.getInstance().findById(id).observe(lo, new Observer<DogModel>() {
        @Override public void onChanged(DogModel dogModelV) {
            dogModel_LD.postValue(dogModelV);
        }});

        return dogModel_LD;
    }

   public MutableLiveData<List<DogModel>> listaDogs(LifecycleOwner lo){
        List<DogModel>                  listaDogs     = new ArrayList<>();
        MutableLiveData<List<DogModel>> listaDogs_LD  = new MutableLiveData<>();

        DogRepository.getInstance().findAll().observe(lo, new Observer<List<DogModel>>() {
        @Override public void onChanged(List<DogModel> dogModelsV) {
            listaDogs.addAll(dogModelsV);
            listaDogs.add(new DogModel(3, "Lisa", R.drawable.lisa));
            listaDogs_LD.postValue(listaDogs);
        }});

        return listaDogs_LD;
   }
}




