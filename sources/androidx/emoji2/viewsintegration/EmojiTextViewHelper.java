package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class EmojiTextViewHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HelperInternal f37009a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class HelperInternal19 extends HelperInternal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f37010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EmojiInputFilter f37011b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f37012c = true;

        HelperInternal19(TextView textView) {
            this.f37010a = textView;
            this.f37011b = new EmojiInputFilter(textView);
        }

        private InputFilter[] f(InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f37011b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f37011b;
            return inputFilterArr2;
        }

        private SparseArray g(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i3 = 0; i3 < inputFilterArr.length; i3++) {
                InputFilter inputFilter = inputFilterArr[i3];
                if (inputFilter instanceof EmojiInputFilter) {
                    sparseArray.put(i3, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] h(InputFilter[] inputFilterArr) {
            SparseArray sparseArrayG = g(inputFilterArr);
            if (sparseArrayG.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayG.size()];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (sparseArrayG.indexOfKey(i4) < 0) {
                    inputFilterArr2[i3] = inputFilterArr[i4];
                    i3++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            return transformationMethod instanceof EmojiTransformationMethod ? ((EmojiTransformationMethod) transformationMethod).a() : transformationMethod;
        }

        private void k() {
            this.f37010a.setFilters(a(this.f37010a.getFilters()));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof EmojiTransformationMethod) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new EmojiTransformationMethod(transformationMethod);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return !this.f37012c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean b() {
            return this.f37012c;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void c(boolean z2) {
            if (z2) {
                l();
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void d(boolean z2) {
            this.f37012c = z2;
            l();
            k();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f37012c ? m(transformationMethod) : j(transformationMethod);
        }

        void i(boolean z2) {
            this.f37012c = z2;
        }

        void l() {
            this.f37010a.setTransformationMethod(e(this.f37010a.getTransformationMethod()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SkippingHelper19 extends HelperInternal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HelperInternal19 f37013a;

        SkippingHelper19(TextView textView) {
            this.f37013a = new HelperInternal19(textView);
        }

        private boolean f() {
            return !EmojiCompat.k();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        InputFilter[] a(InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f37013a.a(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public boolean b() {
            return this.f37013a.b();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void c(boolean z2) {
            if (f()) {
                return;
            }
            this.f37013a.c(z2);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        void d(boolean z2) {
            if (f()) {
                this.f37013a.i(z2);
            } else {
                this.f37013a.d(z2);
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        TransformationMethod e(TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f37013a.e(transformationMethod);
        }
    }

    public EmojiTextViewHelper(TextView textView, boolean z2) {
        Preconditions.i(textView, "textView cannot be null");
        if (z2) {
            this.f37009a = new HelperInternal19(textView);
        } else {
            this.f37009a = new SkippingHelper19(textView);
        }
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f37009a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f37009a.b();
    }

    public void c(boolean z2) {
        this.f37009a.c(z2);
    }

    public void d(boolean z2) {
        this.f37009a.d(z2);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.f37009a.e(transformationMethod);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class HelperInternal {
        HelperInternal() {
        }

        public boolean b() {
            return false;
        }

        InputFilter[] a(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        void c(boolean z2) {
        }

        void d(boolean z2) {
        }

        TransformationMethod e(TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }
}
