package com.superwall.sdk.paywall.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LoadingView extends FrameLayout implements PaywallPurchaseLoadingView {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "LoadingView";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context) {
        this(context, null, 0, 0, null, 30, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // com.superwall.sdk.paywall.view.PaywallPurchaseLoadingView
    public void hideLoading() {
        setVisibility(8);
    }

    @Override // com.superwall.sdk.paywall.view.PaywallPurchaseLoadingView
    public void showLoading() {
        setVisibility(0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, null, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, null, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context, AttributeSet attributeSet, int i3, int i4) {
        this(context, attributeSet, i3, i4, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LoadingView(Context context, AttributeSet attributeSet, int i3, int i4, Integer num, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i5 & 2) != 0 ? null : attributeSet, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4, (i5 & 16) != 0 ? null : num);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context, AttributeSet attributeSet, int i3, int i4, Integer num) {
        super(context.getApplicationContext());
        Intrinsics.checkNotNullParameter(context, "context");
        setTag(TAG);
        setBackgroundColor(0);
        ProgressBar progressBar = new ProgressBar(context.getApplicationContext());
        progressBar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        if (num != null) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(ContextCompat.getColor(context, num.intValue())));
        }
        addView(progressBar);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.superwall.sdk.paywall.view.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return LoadingView._init_$lambda$2(view, motionEvent);
            }
        });
    }
}
