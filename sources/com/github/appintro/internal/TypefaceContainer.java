package com.github.appintro.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class TypefaceContainer {
    private int typeFaceResource;
    private String typeFaceUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public TypefaceContainer() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TypefaceContainer copy$default(TypefaceContainer typefaceContainer, String str, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = typefaceContainer.typeFaceUrl;
        }
        if ((i4 & 2) != 0) {
            i3 = typefaceContainer.typeFaceResource;
        }
        return typefaceContainer.copy(str, i3);
    }

    public final void applyTo(final TextView textView) {
        if (textView == null || textView.getContext() == null) {
            return;
        }
        if (this.typeFaceUrl == null && this.typeFaceResource == 0) {
            return;
        }
        ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback() { // from class: com.github.appintro.internal.TypefaceContainer$applyTo$callback$1
            @Override // androidx.core.content.res.ResourcesCompat.FontCallback
            public void onFontRetrieved(Typeface typeface) {
                Intrinsics.checkNotNullParameter(typeface, "typeface");
                textView.setTypeface(typeface);
            }

            @Override // androidx.core.content.res.ResourcesCompat.FontCallback
            public void onFontRetrievalFailed(int i3) {
            }
        };
        if (this.typeFaceResource != 0) {
            ResourcesCompat.k(textView.getContext(), this.typeFaceResource, fontCallback, null);
            return;
        }
        CustomFontCache customFontCache = CustomFontCache.INSTANCE;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        customFontCache.getFont(context, this.typeFaceUrl, fontCallback);
    }

    public final String component1() {
        return this.typeFaceUrl;
    }

    public final int component2() {
        return this.typeFaceResource;
    }

    public final TypefaceContainer copy(String str, int i3) {
        return new TypefaceContainer(str, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypefaceContainer)) {
            return false;
        }
        TypefaceContainer typefaceContainer = (TypefaceContainer) obj;
        return Intrinsics.areEqual(this.typeFaceUrl, typefaceContainer.typeFaceUrl) && this.typeFaceResource == typefaceContainer.typeFaceResource;
    }

    public final int getTypeFaceResource() {
        return this.typeFaceResource;
    }

    public final String getTypeFaceUrl() {
        return this.typeFaceUrl;
    }

    public int hashCode() {
        String str = this.typeFaceUrl;
        return ((str != null ? str.hashCode() : 0) * 31) + this.typeFaceResource;
    }

    public final void setTypeFaceResource(int i3) {
        this.typeFaceResource = i3;
    }

    public final void setTypeFaceUrl(String str) {
        this.typeFaceUrl = str;
    }

    public String toString() {
        return "TypefaceContainer(typeFaceUrl=" + this.typeFaceUrl + ", typeFaceResource=" + this.typeFaceResource + ")";
    }

    public TypefaceContainer(String str, int i3) {
        this.typeFaceUrl = str;
        this.typeFaceResource = i3;
    }

    public /* synthetic */ TypefaceContainer(String str, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? 0 : i3);
    }
}
