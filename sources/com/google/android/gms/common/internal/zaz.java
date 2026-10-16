package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaz extends RemoteCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zaz f72082a = new zaz();

    private zaz() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int i3, int i4) throws RemoteCreator.RemoteCreatorException {
        zaz zazVar = f72082a;
        try {
            return (View) ObjectWrapper.h5(((zam) zazVar.getRemoteCreatorInstance(context)).x3(ObjectWrapper.i5(context), new zax(1, i3, i4, null)));
        } catch (Exception e3) {
            throw new RemoteCreator.RemoteCreatorException("Could not get button with size " + i3 + " and color " + i4, e3);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof zam ? (zam) iInterfaceQueryLocalInterface : new zam(iBinder);
    }
}
