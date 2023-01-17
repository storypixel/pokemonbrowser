
package com.iamnotsam.pokemonbrowser.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardResponse {

    @SerializedName("data")
    @Expose
    private List<Card> data = null;

    public List<Card> getData() {
        return data;
    }

    public void setData(List<Card> data) {
        this.data = data;
    }

}
