package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfkg {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzfkg(int i3, int i4, boolean z2) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = z2;
    }

    static List zza(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int iNextInt = 0;
            int iNextInt2 = 0;
            boolean zNextBoolean = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (ViewHierarchyConstants.DIMENSION_WIDTH_KEY.equals(strNextName)) {
                    iNextInt = jsonReader.nextInt();
                } else if (ViewHierarchyConstants.DIMENSION_HEIGHT_KEY.equals(strNextName)) {
                    iNextInt2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(strNextName)) {
                    zNextBoolean = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzfkg(iNextInt, iNextInt2, zNextBoolean));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
