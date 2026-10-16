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
import androidx.credentials.provider.utils.CryptoObjectUtils;
import com.facebook.internal.ServerProtocol;
import java.time.Instant;
import java.util.Collections;
import java.util.Iterator;
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
public final class CustomCredentialEntry extends CredentialEntry {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Companion f35324s = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f35325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CharSequence f35326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final PendingIntent f35327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f35328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final CharSequence f35329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CharSequence f35330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Icon f35331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Instant f35332o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f35333p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f35334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f35335r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api28Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api28Impl f35336a = new Api28Impl();

        private Api28Impl() {
        }

        public static final CustomCredentialEntry b(Slice slice) {
            Iterator it;
            Intrinsics.checkNotNullParameter(slice, "slice");
            SliceSpec spec = slice.getSpec();
            Intrinsics.checkNotNull(spec);
            String type = spec.getType();
            Intrinsics.checkNotNullExpressionValue(type, "slice.spec!!.type");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            Iterator it2 = items.iterator();
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            CharSequence text = null;
            CharSequence text2 = null;
            PendingIntent action = null;
            CharSequence text3 = null;
            CharSequence text4 = null;
            Icon icon = null;
            Instant instantOfEpochMilli = null;
            CharSequence text5 = null;
            CharSequence text6 = null;
            while (it2.hasNext()) {
                SliceItem sliceItem = (SliceItem) it2.next();
                if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_OPTION_ID")) {
                    text = sliceItem.getText();
                } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_DEDUPLICATION_ID")) {
                    text5 = sliceItem.getText();
                } else {
                    it = it2;
                    if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED")) {
                        if (Intrinsics.areEqual(sliceItem.getText(), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                            z3 = true;
                        }
                    } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_AFFILIATED_DOMAIN")) {
                        text6 = sliceItem.getText();
                    } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME")) {
                        text4 = sliceItem.getText();
                    } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_USER_NAME")) {
                        text2 = sliceItem.getText();
                    } else if (sliceItem.hasHint("androidx.credentials.provider.credentialEntry.SLICE_HINT_CREDENTIAL_TYPE_DISPLAY_NAME")) {
                        text3 = sliceItem.getText();
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
                    it2 = it;
                }
                it = it2;
                it2 = it;
            }
            try {
                Intrinsics.checkNotNull(text2);
                Intrinsics.checkNotNull(action);
                Intrinsics.checkNotNull(icon);
                Intrinsics.checkNotNull(text);
                return new CustomCredentialEntry(type, text2, action, z2, text3, text4, icon, instantOfEpochMilli, new BeginGetCustomCredentialOption(text.toString(), type, new Bundle()), z3, text5, text6, null, z4, true, z5, 4096, null);
            } catch (Exception e3) {
                Log.i("CredentialEntry", "fromSlice failed with: " + e3.getMessage());
                return null;
            }
        }

        public static final boolean c(CustomCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            return entry.f35333p ? entry.f35334q : entry.i().getType() == 2 && entry.i().getResId() == R.drawable.f34837a;
        }

        public static final Slice d(CustomCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec(entry.e(), 1));
            f35336a.a(entry, builder);
            Slice sliceBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }

        public final void a(CustomCredentialEntry entry, Slice.Builder sliceBuilder) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Intrinsics.checkNotNullParameter(sliceBuilder, "sliceBuilder");
            BeginGetCredentialOption beginGetCredentialOptionB = entry.b();
            sliceBuilder.addText(beginGetCredentialOptionB.b(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_OPTION_ID")).addText(entry.d(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_DEDUPLICATION_ID")).addText(entry.f() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false", null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_IS_DEFAULT_ICON_PREFERRED")).addText(entry.a(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_AFFILIATED_DOMAIN"));
            CharSequence charSequenceM = entry.m();
            CharSequence charSequenceL = entry.l();
            PendingIntent pendingIntentK = entry.k();
            CharSequence charSequenceN = entry.n();
            Instant instantJ = entry.j();
            sliceBuilder.addText(charSequenceN, null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME")).addText(charSequenceM, null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_USER_NAME")).addText(charSequenceL, null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_CREDENTIAL_TYPE_DISPLAY_NAME")).addText(entry.p() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false", null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_ALLOWED")).addIcon(entry.i(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_PROFILE_ICON"));
            try {
                if (entry.o()) {
                    sliceBuilder.addInt(1, null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID"));
                }
            } catch (IllegalStateException unused) {
            }
            if (entry.q()) {
                sliceBuilder.addInt(1, null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION"));
            }
            if (instantJ != null) {
                sliceBuilder.addLong(instantJ.toEpochMilli(), null, CollectionsKt.listOf("androidx.credentials.provider.credentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS"));
            }
            sliceBuilder.addAction(pendingIntentK, new Slice.Builder(sliceBuilder).addHints(Collections.singletonList("androidx.credentials.provider.credentialEntry.SLICE_HINT_PENDING_INTENT")).build(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api34Impl f35337a = new Api34Impl();

        private Api34Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api35Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api35Impl f35338a = new Api35Impl();

        private Api35Impl() {
        }

        public static final CustomCredentialEntry b(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            CustomCredentialEntry customCredentialEntryB = Api28Impl.b(slice);
            if (customCredentialEntryB == null) {
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
                return new CustomCredentialEntry(customCredentialEntryB.e(), customCredentialEntryB.m(), customCredentialEntryB.k(), customCredentialEntryB.p(), customCredentialEntryB.l(), customCredentialEntryB.n(), customCredentialEntryB.i(), customCredentialEntryB.j(), customCredentialEntryB.b(), customCredentialEntryB.f(), customCredentialEntryB.d(), customCredentialEntryB.a(), bundle != null ? BiometricPromptData.f35279d.b(bundle) : null, customCredentialEntryB.q(), true, customCredentialEntryB.f35334q);
            } catch (Exception e3) {
                Log.i("CredentialEntry", "fromSlice failed with: " + e3.getMessage());
                return null;
            }
        }

        public static final Slice c(CustomCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec(entry.e(), 1));
            Api28Impl.f35336a.a(entry, builder);
            f35338a.a(entry, builder);
            Slice sliceBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }

        public final void a(CustomCredentialEntry entry, Slice.Builder sliceBuilder) {
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

        public final CustomCredentialEntry a(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            return Build.VERSION.SDK_INT >= 35 ? Api35Impl.b(slice) : Api28Impl.b(slice);
        }

        public final Slice b(CustomCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            return Build.VERSION.SDK_INT >= 35 ? Api35Impl.c(entry) : Api28Impl.d(entry);
        }

        private Companion() {
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ CustomCredentialEntry(java.lang.String r20, java.lang.CharSequence r21, android.app.PendingIntent r22, boolean r23, java.lang.CharSequence r24, java.lang.CharSequence r25, android.graphics.drawable.Icon r26, java.time.Instant r27, androidx.credentials.provider.BeginGetCredentialOption r28, boolean r29, java.lang.CharSequence r30, java.lang.CharSequence r31, androidx.credentials.provider.BiometricPromptData r32, boolean r33, boolean r34, boolean r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r19 = this;
            r0 = r36
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L9
            r13 = r21
            goto Lb
        L9:
            r13 = r30
        Lb:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            r2 = 0
            if (r1 == 0) goto L12
            r14 = r2
            goto L14
        L12:
            r14 = r31
        L14:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L1a
            r15 = r2
            goto L1c
        L1a:
            r15 = r32
        L1c:
            r1 = r0 & 8192(0x2000, float:1.148E-41)
            if (r1 == 0) goto L2d
            androidx.credentials.CredentialOption$Companion r1 = androidx.credentials.CredentialOption.f34767h
            android.os.Bundle r2 = r28.a()
            boolean r1 = r1.b(r2)
            r16 = r1
            goto L2f
        L2d:
            r16 = r33
        L2f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            r2 = 0
            if (r1 == 0) goto L37
            r17 = r2
            goto L39
        L37:
            r17 = r34
        L39:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L58
            r18 = r2
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r2 = r19
            goto L70
        L58:
            r18 = r35
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
        L70:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CustomCredentialEntry.<init>(java.lang.String, java.lang.CharSequence, android.app.PendingIntent, boolean, java.lang.CharSequence, java.lang.CharSequence, android.graphics.drawable.Icon, java.time.Instant, androidx.credentials.provider.BeginGetCredentialOption, boolean, java.lang.CharSequence, java.lang.CharSequence, androidx.credentials.provider.BiometricPromptData, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // androidx.credentials.provider.CredentialEntry
    public String e() {
        return this.f35325h;
    }

    public final Icon i() {
        return this.f35331n;
    }

    public final Instant j() {
        return this.f35332o;
    }

    public final PendingIntent k() {
        return this.f35327j;
    }

    public final CharSequence l() {
        return this.f35329l;
    }

    public final CharSequence m() {
        return this.f35326i;
    }

    public final CharSequence n() {
        return this.f35330m;
    }

    public final boolean o() {
        return Api28Impl.c(this);
    }

    public final boolean p() {
        return this.f35328k;
    }

    public final boolean q() {
        return this.f35335r;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCredentialEntry(String type, CharSequence title, PendingIntent pendingIntent, boolean z2, CharSequence charSequence, CharSequence charSequence2, Icon icon, Instant instant, BeginGetCredentialOption beginGetCredentialOption, boolean z3, CharSequence charSequence3, CharSequence charSequence4, BiometricPromptData biometricPromptData, boolean z4, boolean z5, boolean z6) {
        super(type, beginGetCredentialOption, charSequence3 == null ? title : charSequence3, z3, charSequence4, biometricPromptData);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(beginGetCredentialOption, "beginGetCredentialOption");
        this.f35325h = type;
        this.f35326i = title;
        this.f35327j = pendingIntent;
        this.f35328k = z2;
        this.f35329l = charSequence;
        this.f35330m = charSequence2;
        this.f35331n = icon;
        this.f35332o = instant;
        this.f35333p = z5;
        this.f35334q = z6;
        this.f35335r = z4;
        if (e().length() > 0) {
            if (title.length() <= 0) {
                throw new IllegalArgumentException("title must not be empty");
            }
            return;
        }
        throw new IllegalArgumentException("type must not be empty");
    }
}
