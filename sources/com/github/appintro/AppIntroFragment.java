package com.github.appintro;

import com.github.appintro.model.SliderPage;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
public final class AppIntroFragment extends AppIntroBaseFragment {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ AppIntroFragment newInstance$default(Companion companion, CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                charSequence = null;
            }
            if ((i10 & 2) != 0) {
                charSequence2 = null;
            }
            if ((i10 & 4) != 0) {
                i3 = 0;
            }
            if ((i10 & 8) != 0) {
                i4 = 0;
            }
            if ((i10 & 16) != 0) {
                i5 = 0;
            }
            if ((i10 & 32) != 0) {
                i6 = 0;
            }
            if ((i10 & 64) != 0) {
                i7 = 0;
            }
            if ((i10 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                i8 = 0;
            }
            if ((i10 & Function.MAX_NARGS) != 0) {
                i9 = 0;
            }
            return companion.newInstance(charSequence, charSequence2, i3, i4, i5, i6, i7, i8, i9);
        }

        @JvmStatic
        public final AppIntroFragment newInstance() {
            return newInstance$default(this, null, null, 0, 0, 0, 0, 0, 0, 0, 511, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AppIntroFragment newInstance(CharSequence charSequence) {
            return newInstance$default(this, charSequence, null, 0, 0, 0, 0, 0, 0, 0, 510, null);
        }

        @JvmStatic
        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2) {
            return newInstance$default(this, charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 508, null);
        }

        @JvmStatic
        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3) {
            return newInstance$default(this, charSequence, charSequence2, i3, 0, 0, 0, 0, 0, 0, 504, null);
        }

        @JvmStatic
        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4) {
            return newInstance$default(this, charSequence, charSequence2, i3, i4, 0, 0, 0, 0, 0, 496, null);
        }

        @JvmStatic
        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5) {
            return newInstance$default(this, charSequence, charSequence2, i3, i4, i5, 0, 0, 0, 0, 480, null);
        }

        @JvmStatic
        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6) {
            return newInstance$default(this, charSequence, charSequence2, i3, i4, i5, i6, 0, 0, 0, 448, null);
        }

        @JvmStatic
        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7) {
            return newInstance$default(this, charSequence, charSequence2, i3, i4, i5, i6, i7, 0, 0, 384, null);
        }

        @JvmStatic
        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8) {
            return newInstance$default(this, charSequence, charSequence2, i3, i4, i5, i6, i7, i8, 0, Function.MAX_NARGS, null);
        }

        @JvmStatic
        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            return newInstance(new SliderPage(charSequence, charSequence2, i3, i4, i5, i6, i7, i8, null, null, i9, 768, null));
        }

        @JvmStatic
        public final AppIntroFragment newInstance(SliderPage sliderPage) {
            Intrinsics.checkNotNullParameter(sliderPage, "sliderPage");
            AppIntroFragment appIntroFragment = new AppIntroFragment();
            appIntroFragment.setArguments(sliderPage.toBundle());
            return appIntroFragment;
        }
    }

    @JvmStatic
    public static final AppIntroFragment newInstance() {
        return Companion.newInstance$default(Companion, null, null, 0, 0, 0, 0, 0, 0, 0, 511, null);
    }

    @Override // com.github.appintro.AppIntroBaseFragment
    protected int getLayoutId() {
        return R.layout.appintro_fragment_intro;
    }

    @JvmStatic
    public static final AppIntroFragment newInstance(SliderPage sliderPage) {
        return Companion.newInstance(sliderPage);
    }

    @JvmStatic
    public static final AppIntroFragment newInstance(CharSequence charSequence) {
        return Companion.newInstance$default(Companion, charSequence, null, 0, 0, 0, 0, 0, 0, 0, 510, null);
    }

    @JvmStatic
    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 508, null);
    }

    @JvmStatic
    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i3, 0, 0, 0, 0, 0, 0, 504, null);
    }

    @JvmStatic
    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i3, i4, 0, 0, 0, 0, 0, 496, null);
    }

    @JvmStatic
    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i3, i4, i5, 0, 0, 0, 0, 480, null);
    }

    @JvmStatic
    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i3, i4, i5, i6, 0, 0, 0, 448, null);
    }

    @JvmStatic
    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i3, i4, i5, i6, i7, 0, 0, 384, null);
    }

    @JvmStatic
    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return Companion.newInstance$default(Companion, charSequence, charSequence2, i3, i4, i5, i6, i7, i8, 0, Function.MAX_NARGS, null);
    }

    @JvmStatic
    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return Companion.newInstance(charSequence, charSequence2, i3, i4, i5, i6, i7, i8, i9);
    }
}
