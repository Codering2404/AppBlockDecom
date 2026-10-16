package com.google.android.gms.identitycredentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SafeParcelable.Class
public final class RegistrationRequest extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f72837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f72838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f72840d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f72841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f72836g = new Companion(null);
    public static final Parcelable.Creator<RegistrationRequest> CREATOR = new RegistrationRequestCreator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RegistrationRequest(byte[] r2, byte[] r3, java.lang.String r4, java.lang.String r5, java.util.List r6) {
        /*
            r1 = this;
            java.lang.String r0 = "credentials"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "matcher"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "requestType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "protocolTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r1.<init>()
            r1.f72837a = r2
            r1.f72838b = r3
            r1.f72839c = r4
            r1.f72840d = r5
            r1.f72841f = r6
            boolean r2 = kotlin.text.StringsKt.p0(r5)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L46
            r2 = r6
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L46
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r2 = r6 instanceof java.util.Collection
            if (r2 == 0) goto L48
            r2 = r6
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L48
        L46:
            r2 = r4
            goto L5f
        L48:
            java.util.Iterator r2 = r6.iterator()
        L4c:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L46
            java.lang.Object r5 = r2.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = kotlin.text.StringsKt.p0(r5)
            if (r5 != 0) goto L4c
            r2 = r3
        L5f:
            java.lang.String r5 = r1.f72839c
            boolean r5 = kotlin.text.StringsKt.p0(r5)
            if (r5 != 0) goto L78
            java.lang.String r5 = r1.f72840d
            int r5 = r5.length()
            if (r5 != 0) goto L78
            java.util.List r5 = r1.f72841f
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L78
            goto L79
        L78:
            r3 = r4
        L79:
            if (r2 != 0) goto Lb0
            if (r3 == 0) goto L7e
            goto Lb0
        L7e:
            java.lang.String r2 = r1.f72839c
            java.lang.String r3 = r1.f72840d
            java.util.List r4 = r1.f72841f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Either type: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = ", or requestType: "
            r5.append(r2)
            r5.append(r3)
            java.lang.String r2 = " and protocolTypes: "
            r5.append(r2)
            r5.append(r4)
            java.lang.String r2 = " must be specified, but all were blank, or for protocolTypes, empty or full of blank elements."
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            r3.<init>(r2)
            throw r3
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.identitycredentials.RegistrationRequest.<init>(byte[], byte[], java.lang.String, java.lang.String, java.util.List):void");
    }

    public final byte[] M() {
        return this.f72837a;
    }

    public final byte[] N() {
        return this.f72838b;
    }

    public final List O() {
        return this.f72841f;
    }

    public final String g0() {
        return this.f72840d;
    }

    public final String j0() {
        return this.f72839c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        RegistrationRequestCreator.c(this, dest, i3);
    }
}
