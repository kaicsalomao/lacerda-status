package com.lacerdagroup.status.ui.leira;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LeiraViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LeiraViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}