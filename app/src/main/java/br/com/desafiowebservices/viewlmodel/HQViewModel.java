package br.com.desafiowebservices.viewlmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.desafiowebservices.data.network.ApiService;
import br.com.desafiowebservices.pojo.Result;
import br.com.desafiowebservices.repository.HQrepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static br.com.desafiowebservices.utils.AppUtil.md5;

public class HQViewModel extends AndroidViewModel {// Variáveis que serão usadas para buscar os quadrinhos na API
    private MutableLiveData<List<Result>> _resultLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> _loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private HQrepository repository = new HQrepository();

    // Construtor padrão do viewmodel
    public HQViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<Result>> getResults() {
        return _resultLiveData;
    }

    public LiveData<Boolean> isLoading(){
        return _loading;
    }

    public void getComics() {

        // Adicionamos a chamada a um disposible para podermos eliminar o disposable da destruição do viewmodel
        disposable.add(repository.getComics()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> _loading.setValue(true))
                .doAfterTerminate(() -> _loading.setValue(false))
                .subscribe(response -> {
                    // Chegou aqui então alteramos o live data, assim a View que está observando ele pode atualizar a tela
                    _resultLiveData.setValue(response.getData().getResults());
                }, throwable -> {
                    Log.i("LOG", "Error: " + throwable.getMessage());
                }));
    }
}

