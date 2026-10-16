package com.google.android.libraries.places.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zznb;
import com.google.android.libraries.places.internal.zznp;
import com.google.android.libraries.places.internal.zznq;
import com.google.android.libraries.places.internal.zznt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class Autocomplete {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static class IntentBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zznp f78849a;

        public IntentBuilder(zznq zznqVar) {
            this.f78849a = zznqVar.t();
        }

        public Intent a(Context context) throws Throwable {
            try {
                Intent intent = new Intent(context, (Class<?>) AutocompleteActivity.class);
                zznp zznpVar = this.f78849a;
                Resources.Theme theme = context.getTheme();
                TypedValue typedValue = new TypedValue();
                if (theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
                    zznpVar.g(typedValue.data);
                }
                TypedValue typedValue2 = new TypedValue();
                if (theme.resolveAttribute(R.attr.colorPrimaryDark, typedValue2, true)) {
                    zznpVar.h(typedValue2.data);
                }
                intent.putExtra("places/AutocompleteOptions", zznpVar.j());
                return intent;
            } catch (Error e3) {
                e = e3;
                zznb.b(e);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                zznb.b(e);
                throw e;
            }
        }
    }

    public static Place a(Intent intent) {
        return zznt.a(intent);
    }

    public static Status b(Intent intent) {
        return zznt.b(intent);
    }
}
