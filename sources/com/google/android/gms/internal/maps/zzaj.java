package com.google.android.gms.internal.maps;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.Cap;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzaj extends IInterface {
    void zzA(boolean z2) throws RemoteException;

    void zzB(float f3) throws RemoteException;

    void zzC(float f3) throws RemoteException;

    boolean zzD(@Nullable zzaj zzajVar) throws RemoteException;

    boolean zzE() throws RemoteException;

    boolean zzF() throws RemoteException;

    boolean zzG() throws RemoteException;

    float zzd() throws RemoteException;

    float zze() throws RemoteException;

    int zzf() throws RemoteException;

    int zzg() throws RemoteException;

    int zzh() throws RemoteException;

    IObjectWrapper zzi() throws RemoteException;

    Cap zzj() throws RemoteException;

    Cap zzk() throws RemoteException;

    String zzl() throws RemoteException;

    List zzm() throws RemoteException;

    List zzn() throws RemoteException;

    List zzo() throws RemoteException;

    void zzp() throws RemoteException;

    void zzq(boolean z2) throws RemoteException;

    void zzr(int i3) throws RemoteException;

    void zzs(Cap cap) throws RemoteException;

    void zzt(boolean z2) throws RemoteException;

    void zzu(int i3) throws RemoteException;

    void zzv(@Nullable List list) throws RemoteException;

    void zzw(List list) throws RemoteException;

    void zzx(List list) throws RemoteException;

    void zzy(Cap cap) throws RemoteException;

    void zzz(IObjectWrapper iObjectWrapper) throws RemoteException;
}
