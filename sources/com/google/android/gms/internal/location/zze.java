package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.checkerframework.dataflow.qual.Pure;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zze extends AbstractSafeParcelable {

    @SafeParcelable.Field
    private final int zzb;

    @SafeParcelable.Field
    private final String zzc;

    @SafeParcelable.Field
    private final String zzd;

    @SafeParcelable.Field
    private final String zze;

    @SafeParcelable.Field
    private final List zzf;

    @SafeParcelable.Field
    private final zze zzg;
    public static final zzd zza = new zzd(null);
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    static {
        Process.myUid();
        Process.myPid();
    }

    @Deprecated
    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param int i3, @SafeParcelable.Param String packageName, @SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param List list, @SafeParcelable.Param zze zzeVar) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (zzeVar != null && zzeVar.zza()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.zzb = i3;
        this.zzc = packageName;
        this.zzd = str;
        this.zze = str2 == null ? zzeVar != null ? zzeVar.zze : null : str2;
        if (list == null) {
            list = zzeVar != null ? zzeVar.zzf : null;
            if (list == null) {
                list = zzex.zzi();
                Intrinsics.checkNotNullExpressionValue(list, "of(...)");
            }
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        zzex zzexVarZzj = zzex.zzj(list);
        Intrinsics.checkNotNullExpressionValue(zzexVarZzj, "copyOf(...)");
        this.zzf = zzexVarZzj;
        this.zzg = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zze) {
            zze zzeVar = (zze) obj;
            if (this.zzb == zzeVar.zzb && Intrinsics.areEqual(this.zzc, zzeVar.zzc) && Intrinsics.areEqual(this.zzd, zzeVar.zzd) && Intrinsics.areEqual(this.zze, zzeVar.zze) && Intrinsics.areEqual(this.zzg, zzeVar.zzg) && Intrinsics.areEqual(this.zzf, zzeVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzg});
    }

    public final String toString() {
        int length = this.zzc.length() + 18;
        String str = this.zzd;
        StringBuilder sb = new StringBuilder(length + (str != null ? str.length() : 0));
        sb.append(this.zzb);
        sb.append("/");
        sb.append(this.zzc);
        String str2 = this.zzd;
        if (str2 != null) {
            sb.append("[");
            if (StringsKt.U(str2, this.zzc, false, 2, null)) {
                sb.append((CharSequence) str2, this.zzc.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append("]");
        }
        if (this.zze != null) {
            sb.append("/");
            String str3 = this.zze;
            sb.append(Integer.toHexString(str3 != null ? str3.hashCode() : 0));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        int i4 = this.zzb;
        int iA = SafeParcelWriter.a(dest);
        SafeParcelWriter.u(dest, 1, i4);
        SafeParcelWriter.G(dest, 3, this.zzc, false);
        SafeParcelWriter.G(dest, 4, this.zzd, false);
        SafeParcelWriter.G(dest, 6, this.zze, false);
        SafeParcelWriter.E(dest, 7, this.zzg, i3, false);
        SafeParcelWriter.K(dest, 8, this.zzf, false);
        SafeParcelWriter.b(dest, iA);
    }

    @Pure
    public final boolean zza() {
        return this.zzg != null;
    }
}
