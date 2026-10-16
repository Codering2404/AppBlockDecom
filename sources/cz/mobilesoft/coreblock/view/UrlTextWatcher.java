package cz.mobilesoft.coreblock.view;

import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import cz.mobilesoft.coreblock.view.badge.BadgeView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class UrlTextWatcher implements TextWatcher {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f130071l = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f130072m = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditText f130073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BadgeView f130074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Pattern f130075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f130076d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f130077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f130078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f130079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f130080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f130081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f130082k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata
    public @interface UrlTextWatcherPattern {
    }

    private final int a() {
        return ((Number) this.f130078g.getValue()).intValue();
    }

    private final int b() {
        return ((Number) this.f130080i.getValue()).intValue();
    }

    private final int c() {
        return ((Number) this.f130079h.getValue()).intValue();
    }

    private final void d(String str) {
        this.f130082k = "";
        if (str.length() == 0) {
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(this.f130076d), 0, str.length(), 33);
        int selectionStart = this.f130073a.getSelectionStart();
        int selectionEnd = this.f130073a.getSelectionEnd();
        this.f130081j = true;
        this.f130073a.setText(spannableString);
        this.f130073a.setSelection(selectionStart, selectionEnd);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        Intrinsics.checkNotNullParameter(s2, "s");
        BadgeView badgeView = this.f130074b;
        if (badgeView != null) {
            Editable text = this.f130073a.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            if (text.length() > 0) {
                if (badgeView.getRotation() == 45.0f) {
                    ViewHelper.k(badgeView, 90.0f);
                    badgeView.getImageView().setColorFilter(c(), PorterDuff.Mode.SRC_IN);
                    badgeView.setBackgroundColor(a());
                    return;
                }
                return;
            }
            if (badgeView.getRotation() == 90.0f) {
                ViewHelper.k(badgeView, 45.0f);
                badgeView.getImageView().setColorFilter(this.f130076d, PorterDuff.Mode.SRC_IN);
                badgeView.setBackgroundColor(b());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(s2, "s");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(s2, "s");
        if (this.f130081j) {
            this.f130081j = false;
            return;
        }
        String string = s2.toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Matcher matcher = this.f130075c.matcher(lowerCase);
        int selectionStart = this.f130073a.getSelectionStart();
        int selectionEnd = this.f130073a.getSelectionEnd();
        if (!matcher.find()) {
            d(lowerCase);
            return;
        }
        String strGroup = matcher.group(4);
        if (strGroup == null) {
            d(lowerCase);
            return;
        }
        int iStart = matcher.start(4);
        int length = strGroup.length();
        if (Intrinsics.areEqual(strGroup, s2)) {
            d(lowerCase);
            return;
        }
        SpannableString spannableString = new SpannableString(lowerCase);
        spannableString.setSpan(new ForegroundColorSpan(this.f130076d), 0, iStart, 33);
        int i6 = length + iStart;
        spannableString.setSpan(new ForegroundColorSpan(this.f130077f), iStart, i6, 33);
        spannableString.setSpan(new ForegroundColorSpan(this.f130076d), i6, lowerCase.length(), 33);
        this.f130081j = true;
        this.f130073a.setText(spannableString);
        this.f130073a.setSelection(selectionStart, selectionEnd);
        this.f130082k = strGroup;
    }
}
