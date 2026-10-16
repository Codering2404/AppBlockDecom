package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AutocompletePrediction implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public AutocompletePrediction a() {
            AutocompletePrediction autocompletePredictionK = k();
            f(ImmutableList.t(autocompletePredictionK.g()));
            h(ImmutableList.t(autocompletePredictionK.k()));
            i(ImmutableList.t(autocompletePredictionK.l()));
            j(ImmutableList.t(autocompletePredictionK.m()));
            return k();
        }

        public abstract Builder b(Integer num);

        public abstract Builder c(String str);

        public abstract Builder d(String str);

        public abstract Builder e(String str);

        public abstract Builder f(List list);

        abstract Builder g(String str);

        public abstract Builder h(List list);

        public abstract Builder i(List list);

        public abstract Builder j(List list);

        abstract AutocompletePrediction k();
    }

    public static Builder a(String str) {
        zzi zziVar = new zzi();
        zziVar.h(new ArrayList());
        zziVar.g(str);
        zziVar.i(new ArrayList());
        zziVar.j(new ArrayList());
        zziVar.f(new ArrayList());
        zziVar.c("");
        zziVar.d("");
        zziVar.e("");
        return zziVar;
    }

    private static final SpannableString n(String str, List list, CharacterStyle characterStyle) {
        SpannableString spannableString = new SpannableString(str);
        if (str.length() != 0 && characterStyle != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzfs zzfsVar = (zzfs) it.next();
                spannableString.setSpan(CharacterStyle.wrap(characterStyle), zzfsVar.c(), zzfsVar.c() + zzfsVar.d(), 0);
            }
        }
        return spannableString;
    }

    public abstract Integer c();

    public abstract String d();

    public SpannableString e(CharacterStyle characterStyle) {
        return n(i(), l(), characterStyle);
    }

    public SpannableString f(CharacterStyle characterStyle) {
        return n(j(), m(), characterStyle);
    }

    public abstract List g();

    abstract String h();

    abstract String i();

    abstract String j();

    abstract List k();

    abstract List l();

    abstract List m();
}
