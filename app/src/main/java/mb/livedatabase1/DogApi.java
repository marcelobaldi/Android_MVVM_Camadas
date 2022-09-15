package mb.livedatabase1;
import androidx.lifecycle.LiveData;
import java.util.List;

interface DogApi {
    LiveData<DogModel>       findById (int id);
    LiveData<List<DogModel>> findAll ();
}

