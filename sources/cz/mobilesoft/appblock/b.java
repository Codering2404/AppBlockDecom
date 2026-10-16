package cz.mobilesoft.appblock;

import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.MainActivity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class b implements MainActivity.MainActivityProvider {
    @Override // cz.mobilesoft.coreblock.MainActivity.MainActivityProvider
    public final Intent a(Context context) {
        return AppBlockApplication.y(context);
    }
}
