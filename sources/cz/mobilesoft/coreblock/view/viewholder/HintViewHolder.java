package cz.mobilesoft.coreblock.view.viewholder;

import android.animation.LayoutTransition;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class HintViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f133459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f133460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence f133461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f133462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function1 f133463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function0 f133464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View f133465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f133466h;

    public HintViewHolder(ViewGroup root, String title, CharSequence description, Function0 function0, final Function1 function1, final Function0 function02) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.f133459a = root;
        this.f133460b = title;
        this.f133461c = description;
        this.f133462d = function0;
        this.f133463e = function1;
        this.f133464f = function02;
        final View viewInflate = LayoutInflater.from(root.getContext()).inflate(R.layout.U, root, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        this.f133465g = viewInflate;
        final CheckedTextView checkedTextView = (CheckedTextView) viewInflate.findViewById(R.id.B0);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.F0);
        final Button button = (Button) viewInflate.findViewById(R.id.D1);
        Intrinsics.checkNotNull(button);
        ViewHelperExtKt.n(button);
        ViewHelperExtKt.o(button);
        checkedTextView.setText(title);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(description);
        if (function1 != null) {
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) viewInflate).getLayoutTransition().addTransitionListener(new LayoutTransition.TransitionListener() { // from class: cz.mobilesoft.coreblock.view.viewholder.HintViewHolder$1$1$1
                @Override // android.animation.LayoutTransition.TransitionListener
                public void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i3) {
                    TextView textView2 = textView;
                    Intrinsics.checkNotNull(textView2);
                    boolean z2 = textView2.getVisibility() == 0;
                    if (this.f133466h != z2) {
                        this.f133466h = z2;
                        if (z2) {
                            function1.invoke(viewInflate);
                        }
                    }
                }

                @Override // android.animation.LayoutTransition.TransitionListener
                public void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i3) {
                }
            });
        }
        checkedTextView.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.view.viewholder.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HintViewHolder.a(checkedTextView, textView, button, this, view);
            }
        });
        if (function02 != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.view.viewholder.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HintViewHolder.b(function02, view);
                }
            });
        }
    }

    public static void a(CheckedTextView checkedTextView, TextView textView, Button button, HintViewHolder hintViewHolder, View view) {
        Function0 function0;
        checkedTextView.setChecked(!checkedTextView.isChecked());
        Intrinsics.checkNotNull(textView);
        int i3 = 8;
        textView.setVisibility(checkedTextView.isChecked() ? 0 : 8);
        Intrinsics.checkNotNull(button);
        if (hintViewHolder.f133464f != null && checkedTextView.isChecked()) {
            i3 = 0;
        }
        button.setVisibility(i3);
        if (!checkedTextView.isChecked() || (function0 = hintViewHolder.f133462d) == null) {
            return;
        }
        function0.invoke();
    }

    public static void b(Function0 function0, View view) {
        function0.invoke();
    }

    public final View e() {
        return this.f133465g;
    }

    public /* synthetic */ HintViewHolder(ViewGroup viewGroup, String str, CharSequence charSequence, Function0 function0, Function1 function1, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, str, charSequence, (i3 & 8) != 0 ? null : function0, (i3 & 16) != 0 ? null : function1, (i3 & 32) != 0 ? null : function02);
    }
}
