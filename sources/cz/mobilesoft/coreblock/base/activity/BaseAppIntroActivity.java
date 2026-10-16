package cz.mobilesoft.coreblock.base.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.core.content.ContextCompat;
import com.github.appintro.AppIntro2;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.view.GradientUtils;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseAppIntroActivity extends AppIntro2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f96305a = R.layout.f95684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f96306b = R.color.f95448c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageButton f96307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageButton f96308d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageButton f96309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageButton f96310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageButton f96311h;

    private final void a0() {
        View viewFindViewById = findViewById(R.id.f95641n);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        d0((ImageButton) viewFindViewById);
        View viewFindViewById2 = findViewById(R.id.f95643n1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        h0((ImageButton) viewFindViewById2);
        View viewFindViewById3 = findViewById(R.id.V1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        i0((ImageButton) viewFindViewById3);
        View viewFindViewById4 = findViewById(R.id.f95618h0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        g0((ImageButton) viewFindViewById4);
        View viewFindViewById5 = findViewById(R.id.H);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        f0((ImageButton) viewFindViewById5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(BaseAppIntroActivity baseAppIntroActivity, View view) {
        baseAppIntroActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(BaseAppIntroActivity baseAppIntroActivity, View view) {
        baseAppIntroActivity.finish();
    }

    public final ImageButton V() {
        ImageButton imageButton = this.f96307c;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backButton");
        return null;
    }

    public final ImageButton W() {
        ImageButton imageButton = this.f96311h;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeButton");
        return null;
    }

    public final ImageButton X() {
        ImageButton imageButton = this.f96310g;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("doneButton");
        return null;
    }

    public final ImageButton Y() {
        ImageButton imageButton = this.f96308d;
        if (imageButton != null) {
            return imageButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nextButton");
        return null;
    }

    public int Z() {
        return this.f96306b;
    }

    public final void d0(ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.f96307c = imageButton;
    }

    public final void f0(ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.f96311h = imageButton;
    }

    public final void g0(ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.f96310g = imageButton;
    }

    @Override // com.github.appintro.AppIntro2, com.github.appintro.AppIntroBase
    protected int getLayoutId() {
        return this.f96305a;
    }

    public final void h0(ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.f96308d = imageButton;
    }

    public final void i0(ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.f96309f = imageButton;
    }

    @Override // com.github.appintro.AppIntro2, com.github.appintro.AppIntroBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a0();
        setStatusBarColor(ContextCompat.getColor(this, Z()));
        showStatusBar(true);
        if (!ViewHelper.e(this)) {
            GradientUtils.a(this);
        }
        setWizardMode(true);
        setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.f95448c)));
        int color = ContextCompat.getColor(this, R.color.f95446a);
        setIndicatorColor(color, ContextCompat.getColor(this, R.color.f95457l));
        ImageButton imageButtonV = V();
        int i3 = R.drawable.Q3;
        imageButtonV.setImageResource(i3);
        Y().setImageResource(i3);
        X().setImageResource(R.drawable.f95555q1);
        X().setColorFilter(color);
        X().setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.base.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseAppIntroActivity.b0(this.f96323a, view);
            }
        });
        W().setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.base.activity.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseAppIntroActivity.c0(this.f96324a, view);
            }
        });
    }
}
