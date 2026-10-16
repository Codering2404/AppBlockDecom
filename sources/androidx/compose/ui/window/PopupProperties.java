package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PopupProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f30283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f30284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f30285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f30286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f30287f;

    public PopupProperties(int i3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f30282a = i3;
        this.f30283b = z2;
        this.f30284c = z3;
        this.f30285d = z4;
        this.f30286e = z5;
        this.f30287f = z6;
    }

    public final boolean a() {
        return this.f30284c;
    }

    public final boolean b() {
        return this.f30285d;
    }

    public final boolean c() {
        return this.f30286e;
    }

    public final int d() {
        return this.f30282a;
    }

    public final boolean e() {
        return this.f30283b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupProperties)) {
            return false;
        }
        PopupProperties popupProperties = (PopupProperties) obj;
        return this.f30282a == popupProperties.f30282a && this.f30283b == popupProperties.f30283b && this.f30284c == popupProperties.f30284c && this.f30285d == popupProperties.f30285d && this.f30286e == popupProperties.f30286e && this.f30287f == popupProperties.f30287f;
    }

    public final boolean f() {
        return this.f30287f;
    }

    public int hashCode() {
        return (((((((((this.f30282a * 31) + Boolean.hashCode(this.f30283b)) * 31) + Boolean.hashCode(this.f30284c)) * 31) + Boolean.hashCode(this.f30285d)) * 31) + Boolean.hashCode(this.f30286e)) * 31) + Boolean.hashCode(this.f30287f);
    }

    public /* synthetic */ PopupProperties(int i3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i4 & 2) != 0 ? true : z2, (i4 & 4) != 0 ? true : z3, (i4 & 8) != 0 ? true : z4, (i4 & 16) != 0 ? true : z5, (i4 & 32) != 0 ? false : z6);
    }

    public /* synthetic */ PopupProperties(boolean z2, boolean z3, boolean z4, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? true : z3, (i3 & 4) != 0 ? true : z4, (i3 & 8) != 0 ? true : z5);
    }

    public PopupProperties(boolean z2, boolean z3, boolean z4, boolean z5) {
        this(z2, z3, z4, SecureFlagPolicy.f30288a, true, z5);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PopupProperties(boolean r2, boolean r3, boolean r4, androidx.compose.ui.window.SecureFlagPolicy r5, boolean r6, boolean r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L5
            r2 = 0
        L5:
            r9 = r8 & 2
            r0 = 1
            if (r9 == 0) goto Lb
            r3 = r0
        Lb:
            r9 = r8 & 4
            if (r9 == 0) goto L10
            r4 = r0
        L10:
            r9 = r8 & 8
            if (r9 == 0) goto L16
            androidx.compose.ui.window.SecureFlagPolicy r5 = androidx.compose.ui.window.SecureFlagPolicy.f30288a
        L16:
            r9 = r8 & 16
            if (r9 == 0) goto L1b
            r6 = r0
        L1b:
            r8 = r8 & 32
            if (r8 == 0) goto L27
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2e
        L27:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2e:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupProperties.<init>(boolean, boolean, boolean, androidx.compose.ui.window.SecureFlagPolicy, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public PopupProperties(boolean z2, boolean z3, boolean z4, SecureFlagPolicy secureFlagPolicy, boolean z5, boolean z6) {
        this(z2, z3, z4, secureFlagPolicy, z5, z6, false);
    }

    public PopupProperties(boolean z2, boolean z3, boolean z4, SecureFlagPolicy secureFlagPolicy, boolean z5, boolean z6, boolean z7) {
        this(AndroidPopup_androidKt.i(z2, secureFlagPolicy, z6), secureFlagPolicy == SecureFlagPolicy.f30288a, z3, z4, z5, z7);
    }
}
