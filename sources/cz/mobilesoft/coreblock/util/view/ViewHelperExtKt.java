package cz.mobilesoft.coreblock.util.view;

import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseActivitySurface;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.RoundedOutlineProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.ParticleSystem;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ViewHelperExtKt {
    public static final void b(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Drawable drawableB = AppCompatResources.b(imageView.getContext(), R.drawable.f95576x0);
        imageView.setImageDrawable(drawableB);
        if (drawableB instanceof AnimatedVectorDrawable) {
            ((AnimatedVectorDrawable) drawableB).start();
        }
    }

    public static final void c(final KonfettiView konfettiView) {
        Intrinsics.checkNotNullParameter(konfettiView, "<this>");
        final List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.color.f95449d), Integer.valueOf(R.color.f95450e), Integer.valueOf(R.color.f95451f), Integer.valueOf(R.color.f95452g), Integer.valueOf(R.color.f95453h), Integer.valueOf(R.color.f95454i)});
        konfettiView.post(new Runnable() { // from class: cz.mobilesoft.coreblock.util.view.c
            @Override // java.lang.Runnable
            public final void run() {
                ViewHelperExtKt.d(konfettiView, listListOf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(KonfettiView konfettiView, List list) {
        ParticleSystem particleSystemA = konfettiView.a();
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(ContextCompat.getColor(konfettiView.getContext(), ((Number) it.next()).intValue())));
        }
        particleSystemA.a(arrayList).h(0.0d, 359.0d).k(2.0f, 10.0f).i(true).l(1000L).b(Shape.Square.f143770a, Shape.Circle.f143765b).c(new Size(12, 0.0f, 2, null)).j(-50.0f, Float.valueOf(konfettiView.getWidth() + 50.0f), -50.0f, Float.valueOf(-50.0f)).d(200);
    }

    public static final int e(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final void f(Context context, Function1 load) {
        Intrinsics.checkNotNullParameter(load, "load");
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isDestroyed() || activity.isFinishing()) {
                    return;
                }
            }
            RequestManager requestManagerT = Glide.t(context);
            Intrinsics.checkNotNullExpressionValue(requestManagerT, "with(...)");
            load.invoke(requestManagerT);
        }
    }

    public static final void g(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1024);
        window.setStatusBarColor(0);
    }

    public static final void h(final RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: cz.mobilesoft.coreblock.util.view.ViewHelperExtKt$setAlwaysSetScrollToNewItems$1
                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeInserted(int i3, int i4) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                    if (linearLayoutManager != null) {
                        linearLayoutManager.D2(i3, 0);
                    }
                }
            });
        }
    }

    public static final void i(View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(i3);
        int i4 = dimensionPixelSize * 2;
        view.setOutlineProvider(new RoundedOutlineProvider(dimensionPixelSize, Integer.valueOf(i4), Integer.valueOf(i4)));
        view.setClipToOutline(true);
    }

    public static final void j(TextView textView, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        String string = textView.getContext().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        k(textView, string, z2);
    }

    public static final void k(TextView textView, String text, boolean z2) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        textView.setText(StringHelperExtKt.f(text, z2));
    }

    public static /* synthetic */ void l(TextView textView, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z2 = false;
        }
        j(textView, i3, z2);
    }

    public static /* synthetic */ void m(TextView textView, String str, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        k(textView, str, z2);
    }

    public static final void n(Button button) {
        Intrinsics.checkNotNullParameter(button, "<this>");
        int iL0 = PrefManager.f126839a.L0();
        if (iL0 != -1) {
            button.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{android.R.attr.state_enabled}}, new int[]{ContextCompat.getColor(button.getContext(), R.color.f95461p), iL0}));
        }
    }

    public static final void o(Button button) {
        Intrinsics.checkNotNullParameter(button, "<this>");
        String strN0 = PrefManager.f126839a.N0();
        if (strN0 == null || StringsKt.p0(strN0)) {
            return;
        }
        p(button, strN0);
    }

    private static final void p(Button button, String str) {
        String language = button.getResources().getConfiguration().getLocales().get(0).getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        if (StringsKt.U(language, "en", false, 2, null)) {
            button.setText(str);
        }
    }

    public static final void q(View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOutlineProvider(new RoundedOutlineProvider(view.getResources().getDimensionPixelSize(i3), null, null, 6, null));
        view.setClipToOutline(true);
    }

    public static final void r(final Fragment fragment, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.n(new RecyclerView.OnScrollListener() { // from class: cz.mobilesoft.coreblock.util.view.ViewHelperExtKt$setUpRecyclerForSurfaceActivity$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView2, int i3, int i4) throws IllegalAccessException {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                FragmentActivity activity = fragment.getActivity();
                BaseActivitySurface baseActivitySurface = activity instanceof BaseActivitySurface ? (BaseActivitySurface) activity : null;
                if (baseActivitySurface != null) {
                    baseActivitySurface.e(!recyclerView2.canScrollVertically(-1));
                }
            }
        });
    }

    public static final void s(RadioGroup radioGroup) {
        Intrinsics.checkNotNullParameter(radioGroup, "<this>");
        radioGroup.setClipToPadding(false);
        radioGroup.setClipChildren(false);
        int childCount = radioGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = radioGroup.getChildAt(i3);
            Intrinsics.checkNotNull(childAt);
            q(childAt, R.dimen.f95487u);
            childAt.setStateListAnimator(AnimatorInflater.loadStateListAnimator(radioGroup.getContext(), R.animator.f95432a));
        }
        radioGroup.requestLayout();
    }

    public static final void t(TabLayout tabLayout) {
        Intrinsics.checkNotNullParameter(tabLayout, "<this>");
        tabLayout.setClipToPadding(false);
        tabLayout.setClipChildren(false);
        View childAt = tabLayout.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) childAt;
        viewGroup.setClipToPadding(false);
        viewGroup.setClipChildren(false);
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = viewGroup.getChildAt(i3);
            Intrinsics.checkNotNull(childAt2);
            q(childAt2, R.dimen.f95487u);
            childAt2.setStateListAnimator(AnimatorInflater.loadStateListAnimator(tabLayout.getContext(), R.animator.f95433b));
            childAt2.setBackgroundResource(R.drawable.f95557r);
        }
        tabLayout.requestLayout();
    }

    public static final void u(Fragment fragment, int i3) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        String string = fragment.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        v(fragment, string);
    }

    public static final void v(Fragment fragment, String text) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        View view = fragment.getView();
        if (view != null) {
            try {
                Snackbar.k0(view, text, -1).Y();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static final void w(MaterialCardView materialCardView) {
        Intrinsics.checkNotNullParameter(materialCardView, "<this>");
        int dimensionPixelSize = materialCardView.getResources().getDimensionPixelSize(R.dimen.f95467a);
        ViewGroup.LayoutParams layoutParams = materialCardView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            materialCardView.setLayoutParams(marginLayoutParams);
        }
        marginLayoutParams.setMargins(dimensionPixelSize, marginLayoutParams.topMargin, dimensionPixelSize, marginLayoutParams.bottomMargin);
    }

    public static final void x(MaterialCardView materialCardView) {
        Intrinsics.checkNotNullParameter(materialCardView, "<this>");
        y(materialCardView);
        w(materialCardView);
    }

    public static final void y(MaterialCardView materialCardView) {
        Intrinsics.checkNotNullParameter(materialCardView, "<this>");
        int dimensionPixelSize = materialCardView.getResources().getDimensionPixelSize(R.dimen.f95482p);
        ViewGroup.LayoutParams layoutParams = materialCardView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            materialCardView.setLayoutParams(marginLayoutParams);
        }
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, dimensionPixelSize, marginLayoutParams.rightMargin, dimensionPixelSize);
    }
}
