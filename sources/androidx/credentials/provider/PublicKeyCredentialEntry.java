package androidx.credentials.provider;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.credentials.R;
import androidx.credentials.provider.BeginGetPublicKeyCredentialOption;
import androidx.credentials.provider.utils.CryptoObjectUtils;
import com.facebook.internal.ServerProtocol;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PublicKeyCredentialEntry extends CredentialEntry {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Companion f35361r = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CharSequence f35362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CharSequence f35363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CharSequence f35364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PendingIntent f35365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Icon f35366l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Instant f35367m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f35368n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f35369o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f35370p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f35371q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api28Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api28Impl f35372a = new Api28Impl();

        private Api28Impl() {
        }

        public static final PublicKeyCredentialEntry b(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            CharSequence text = null;
            CharSequence text2 = null;
            CharSequence text3 = null;
            PendingIntent action = null;
            Icon icon = null;
            Instant instantOfEpochMilli = null;
            CharSequence text4 = null;
            CharSequence text5 = null;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            CharSequence text6 = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_OPTION_ID")) {
                    text6 = sliceItem.getText();
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_DEDUPLICATION_ID")) {
                    text4 = sliceItem.getText();
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED")) {
                    if (Intrinsics.areEqual(sliceItem.getText(), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        z3 = true;
                    }
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_AFFILIATED_DOMAIN")) {
                    text5 = sliceItem.getText();
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME")) {
                    text3 = sliceItem.getText();
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_USER_NAME")) {
                    text = sliceItem.getText();
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_CREDENTIAL_TYPE_DISPLAY_NAME")) {
                    text2 = sliceItem.getText();
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_PROFILE_ICON")) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_PENDING_INTENT")) {
                    action = sliceItem.getAction();
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS")) {
                    instantOfEpochMilli = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_ALLOWED")) {
                    if (Intrinsics.areEqual(sliceItem.getText(), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        z2 = true;
                    }
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION")) {
                    z4 = true;
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID")) {
                    z5 = true;
                }
            }
            try {
                Intrinsics.checkNotNull(text);
                Intrinsics.checkNotNull(text3);
                Intrinsics.checkNotNull(action);
                Intrinsics.checkNotNull(icon);
                BeginGetPublicKeyCredentialOption.Companion companion = BeginGetPublicKeyCredentialOption.f35276g;
                Bundle bundle = new Bundle();
                Intrinsics.checkNotNull(text6);
                return new PublicKeyCredentialEntry(text, text2, text3, action, icon, instantOfEpochMilli, z2, companion.b(bundle, text6.toString()), z3, text4, text5, null, z4, true, z5, 2048, null);
            } catch (Exception e3) {
                Log.i("PublicKeyCredEntry", "fromSlice failed with: " + e3.getMessage());
                return null;
            }
        }

        public static final boolean c(PublicKeyCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            return entry.f35369o ? entry.f35370p : entry.j().getType() == 2 && entry.j().getResId() == R.drawable.f34838b;
        }

        public static final Slice d(PublicKeyCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec(entry.e(), 1));
            f35372a.a(entry, builder);
            Slice sliceBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }

        public final void a(PublicKeyCredentialEntry entry, Slice.Builder sliceBuilder) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Intrinsics.checkNotNullParameter(sliceBuilder, "sliceBuilder");
            BeginGetCredentialOption beginGetCredentialOptionB = entry.b();
            sliceBuilder.addText(beginGetCredentialOptionB.b(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_OPTION_ID")).addText(entry.d(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_DEDUPLICATION_ID")).addText(entry.f() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false", null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED")).addText(entry.a(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_AFFILIATED_DOMAIN"));
            CharSequence charSequenceN = entry.n();
            CharSequence charSequenceI = entry.i();
            PendingIntent pendingIntentL = entry.l();
            CharSequence charSequenceM = entry.m();
            Instant instantK = entry.k();
            sliceBuilder.addText(charSequenceM, null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME")).addText(charSequenceN, null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_USER_NAME")).addText(charSequenceI, null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_CREDENTIAL_TYPE_DISPLAY_NAME")).addText(entry.p() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false", null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_ALLOWED")).addIcon(entry.j(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_PROFILE_ICON"));
            try {
                if (entry.o()) {
                    sliceBuilder.addInt(1, null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID"));
                }
            } catch (IllegalStateException unused) {
            }
            if (entry.q()) {
                sliceBuilder.addInt(1, null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION"));
            }
            if (instantK != null) {
                sliceBuilder.addLong(instantK.toEpochMilli(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS"));
            }
            sliceBuilder.addAction(pendingIntentL, new Slice.Builder(sliceBuilder).addHints(Collections.singletonList("androidx.credentials.provider.credentialEntry.SLICE_HINT_PENDING_INTENT")).build(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api34Impl f35373a = new Api34Impl();

        private Api34Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api35Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api35Impl f35374a = new Api35Impl();

        private Api35Impl() {
        }

        public static final PublicKeyCredentialEntry b(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            PublicKeyCredentialEntry publicKeyCredentialEntryB = Api28Impl.b(slice);
            if (publicKeyCredentialEntryB == null) {
                return null;
            }
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            Bundle bundle = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_BIOMETRIC_PROMPT_DATA")) {
                    bundle = sliceItem.getBundle();
                }
            }
            try {
                CharSequence charSequenceN = publicKeyCredentialEntryB.n();
                CharSequence charSequenceI = publicKeyCredentialEntryB.i();
                CharSequence charSequenceM = publicKeyCredentialEntryB.m();
                PendingIntent pendingIntentL = publicKeyCredentialEntryB.l();
                Icon iconJ = publicKeyCredentialEntryB.j();
                Instant instantK = publicKeyCredentialEntryB.k();
                boolean zP = publicKeyCredentialEntryB.p();
                BeginGetCredentialOption beginGetCredentialOptionB = publicKeyCredentialEntryB.b();
                Intrinsics.checkNotNull(beginGetCredentialOptionB, "null cannot be cast to non-null type androidx.credentials.provider.BeginGetPublicKeyCredentialOption");
                return new PublicKeyCredentialEntry(charSequenceN, charSequenceI, charSequenceM, pendingIntentL, iconJ, instantK, zP, (BeginGetPublicKeyCredentialOption) beginGetCredentialOptionB, publicKeyCredentialEntryB.f(), publicKeyCredentialEntryB.d(), publicKeyCredentialEntryB.a(), bundle != null ? BiometricPromptData.f35279d.b(bundle) : null, publicKeyCredentialEntryB.q(), true, publicKeyCredentialEntryB.f35370p);
            } catch (Exception e3) {
                Log.i("PublicKeyCredEntry", "fromSlice failed with: " + e3.getMessage());
                return null;
            }
        }

        public static final Slice c(PublicKeyCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec(entry.e(), 1));
            Api28Impl.f35372a.a(entry, builder);
            f35374a.a(entry, builder);
            Slice sliceBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }

        public final void a(PublicKeyCredentialEntry entry, Slice.Builder sliceBuilder) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Intrinsics.checkNotNullParameter(sliceBuilder, "sliceBuilder");
            BiometricPromptData biometricPromptDataC = entry.c();
            if (biometricPromptDataC != null) {
                sliceBuilder.addInt(biometricPromptDataC.a(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_ALLOWED_AUTHENTICATORS"));
                if (biometricPromptDataC.b() != null) {
                    sliceBuilder.addLong(CryptoObjectUtils.f35401a.a(biometricPromptDataC.b()), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_CRYPTO_OP_ID"));
                }
                sliceBuilder.addBundle(BiometricPromptData.f35279d.d(biometricPromptDataC), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_BIOMETRIC_PROMPT_DATA"));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PublicKeyCredentialEntry a(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            return Build.VERSION.SDK_INT >= 35 ? Api35Impl.b(slice) : Api28Impl.b(slice);
        }

        public final Slice b(PublicKeyCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            return Build.VERSION.SDK_INT >= 35 ? Api35Impl.c(entry) : Api28Impl.d(entry);
        }

        private Companion() {
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PublicKeyCredentialEntry(java.lang.CharSequence r19, java.lang.CharSequence r20, java.lang.CharSequence r21, android.app.PendingIntent r22, android.graphics.drawable.Icon r23, java.time.Instant r24, boolean r25, androidx.credentials.provider.BeginGetPublicKeyCredentialOption r26, boolean r27, java.lang.CharSequence r28, java.lang.CharSequence r29, androidx.credentials.provider.BiometricPromptData r30, boolean r31, boolean r32, boolean r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r18 = this;
            r0 = r34
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L9
            r12 = r19
            goto Lb
        L9:
            r12 = r28
        Lb:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r2 = 0
            if (r1 == 0) goto L12
            r13 = r2
            goto L14
        L12:
            r13 = r29
        L14:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L1a
            r14 = r2
            goto L1c
        L1a:
            r14 = r30
        L1c:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L2c
            androidx.credentials.CredentialOption$Companion r1 = androidx.credentials.CredentialOption.f34767h
            android.os.Bundle r2 = r26.a()
            boolean r1 = r1.b(r2)
            r15 = r1
            goto L2e
        L2c:
            r15 = r31
        L2e:
            r1 = r0 & 8192(0x2000, float:1.148E-41)
            r2 = 0
            if (r1 == 0) goto L36
            r16 = r2
            goto L38
        L36:
            r16 = r32
        L38:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L53
            r17 = r2
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            r2 = r18
            goto L69
        L53:
            r17 = r33
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
        L69:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PublicKeyCredentialEntry.<init>(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, android.app.PendingIntent, android.graphics.drawable.Icon, java.time.Instant, boolean, androidx.credentials.provider.BeginGetPublicKeyCredentialOption, boolean, java.lang.CharSequence, java.lang.CharSequence, androidx.credentials.provider.BiometricPromptData, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final CharSequence i() {
        return this.f35363i;
    }

    public final Icon j() {
        return this.f35366l;
    }

    public final Instant k() {
        return this.f35367m;
    }

    public final PendingIntent l() {
        return this.f35365k;
    }

    public final CharSequence m() {
        return this.f35364j;
    }

    public final CharSequence n() {
        return this.f35362h;
    }

    public final boolean o() {
        return Api28Impl.c(this);
    }

    public final boolean p() {
        return this.f35368n;
    }

    public final boolean q() {
        return this.f35371q;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublicKeyCredentialEntry(CharSequence username, CharSequence charSequence, CharSequence typeDisplayName, PendingIntent pendingIntent, Icon icon, Instant instant, boolean z2, BeginGetPublicKeyCredentialOption beginGetPublicKeyCredentialOption, boolean z3, CharSequence charSequence2, CharSequence charSequence3, BiometricPromptData biometricPromptData, boolean z4, boolean z5, boolean z6) {
        super("androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL", beginGetPublicKeyCredentialOption, charSequence2 == null ? username : charSequence2, z3, charSequence3, biometricPromptData);
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(typeDisplayName, "typeDisplayName");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(beginGetPublicKeyCredentialOption, "beginGetPublicKeyCredentialOption");
        this.f35362h = username;
        this.f35363i = charSequence;
        this.f35364j = typeDisplayName;
        this.f35365k = pendingIntent;
        this.f35366l = icon;
        this.f35367m = instant;
        this.f35368n = z2;
        this.f35369o = z5;
        this.f35370p = z6;
        this.f35371q = z4;
        if (username.length() > 0) {
            if (typeDisplayName.length() <= 0) {
                throw new IllegalArgumentException("typeDisplayName must not be empty");
            }
            return;
        }
        throw new IllegalArgumentException("username must not be empty");
    }
}
