package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class EmojiProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EmojiCompat.SpanFactory f36884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MetadataRepo f36885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EmojiCompat.GlyphChecker f36886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f36887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f36888e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CodepointIndexFinder {
        static int a(CharSequence charSequence, int i3, int i4) {
            int length = charSequence.length();
            if (i3 < 0 || length < i3 || i4 < 0) {
                return -1;
            }
            while (true) {
                boolean z2 = false;
                while (i4 != 0) {
                    i3--;
                    if (i3 < 0) {
                        return z2 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i3);
                    if (z2) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i4--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i4--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z2 = true;
                    }
                }
                return i3;
            }
        }

        static int b(CharSequence charSequence, int i3, int i4) {
            int length = charSequence.length();
            if (i3 < 0 || length < i3 || i4 < 0) {
                return -1;
            }
            while (true) {
                boolean z2 = false;
                while (i4 != 0) {
                    if (i3 >= length) {
                        if (z2) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i3);
                    if (z2) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i4--;
                        i3++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i4--;
                        i3++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i3++;
                        z2 = true;
                    }
                }
                return i3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EmojiProcessAddSpanCallback implements EmojiProcessCallback<UnprecomputeTextOnModificationSpannable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UnprecomputeTextOnModificationSpannable f36889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EmojiCompat.SpanFactory f36890b;

        EmojiProcessAddSpanCallback(UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable, EmojiCompat.SpanFactory spanFactory) {
            this.f36889a = unprecomputeTextOnModificationSpannable;
            this.f36890b = spanFactory;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean a(CharSequence charSequence, int i3, int i4, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (typefaceEmojiRasterizer.k()) {
                return true;
            }
            if (this.f36889a == null) {
                this.f36889a = new UnprecomputeTextOnModificationSpannable(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.f36889a.setSpan(this.f36890b.a(typefaceEmojiRasterizer), i3, i4, 33);
            return true;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UnprecomputeTextOnModificationSpannable getResult() {
            return this.f36889a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface EmojiProcessCallback<T> {
        boolean a(CharSequence charSequence, int i3, int i4, TypefaceEmojiRasterizer typefaceEmojiRasterizer);

        Object getResult();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ProcessorSm {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f36895a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MetadataRepo.Node f36896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private MetadataRepo.Node f36897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MetadataRepo.Node f36898d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f36899e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f36900f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f36901g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int[] f36902h;

        ProcessorSm(MetadataRepo.Node node, boolean z2, int[] iArr) {
            this.f36896b = node;
            this.f36897c = node;
            this.f36901g = z2;
            this.f36902h = iArr;
        }

        private static boolean d(int i3) {
            return i3 == 65039;
        }

        private static boolean f(int i3) {
            return i3 == 65038;
        }

        private int g() {
            this.f36895a = 1;
            this.f36897c = this.f36896b;
            this.f36900f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f36897c.b().j() || d(this.f36899e)) {
                return true;
            }
            if (this.f36901g) {
                if (this.f36902h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f36902h, this.f36897c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i3) {
            MetadataRepo.Node nodeA = this.f36897c.a(i3);
            int iG = 2;
            if (this.f36895a != 2) {
                if (nodeA == null) {
                    iG = g();
                } else {
                    this.f36895a = 2;
                    this.f36897c = nodeA;
                    this.f36900f = 1;
                }
            } else if (nodeA != null) {
                this.f36897c = nodeA;
                this.f36900f++;
            } else if (f(i3)) {
                iG = g();
            } else if (!d(i3)) {
                if (this.f36897c.b() != null) {
                    iG = 3;
                    if (this.f36900f != 1 || h()) {
                        this.f36898d = this.f36897c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.f36899e = i3;
            return iG;
        }

        TypefaceEmojiRasterizer b() {
            return this.f36897c.b();
        }

        TypefaceEmojiRasterizer c() {
            return this.f36898d.b();
        }

        boolean e() {
            if (this.f36895a != 2 || this.f36897c.b() == null) {
                return false;
            }
            return this.f36900f > 1 || h();
        }
    }

    EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.SpanFactory spanFactory, EmojiCompat.GlyphChecker glyphChecker, boolean z2, int[] iArr, Set set) {
        this.f36884a = spanFactory;
        this.f36885b = metadataRepo;
        this.f36886c = glyphChecker;
        this.f36887d = z2;
        this.f36888e = iArr;
        i(set);
    }

    private static boolean a(Editable editable, KeyEvent keyEvent, boolean z2) {
        EmojiSpan[] emojiSpanArr;
        if (h(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!g(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            for (EmojiSpan emojiSpan : emojiSpanArr) {
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((z2 && spanStart == selectionStart) || ((!z2 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean d(InputConnection inputConnection, Editable editable, int i3, int i4, boolean z2) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i3 >= 0 && i4 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (g(selectionStart, selectionEnd)) {
                return false;
            }
            if (z2) {
                iMax = CodepointIndexFinder.a(editable, selectionStart, Math.max(i3, 0));
                iMin = CodepointIndexFinder.b(editable, selectionEnd, Math.max(i4, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i3, 0);
                iMin = Math.min(selectionEnd + i4, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(iMax, iMin, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean e(Editable editable, int i3, KeyEvent keyEvent) {
        if (!(i3 != 67 ? i3 != 112 ? false : a(editable, keyEvent, true) : a(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean f(CharSequence charSequence, int i3, int i4, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (typefaceEmojiRasterizer.d() == 0) {
            typefaceEmojiRasterizer.m(this.f36886c.a(charSequence, i3, i4, typefaceEmojiRasterizer.h()));
        }
        return typefaceEmojiRasterizer.d() == 2;
    }

    private static boolean g(int i3, int i4) {
        return i3 == -1 || i4 == -1 || i3 != i4;
    }

    private static boolean h(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void i(Set set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            k(str, 0, str.length(), 1, true, new MarkExclusionCallback(str));
        }
    }

    private Object k(CharSequence charSequence, int i3, int i4, int i5, boolean z2, EmojiProcessCallback emojiProcessCallback) {
        int iCharCount;
        ProcessorSm processorSm = new ProcessorSm(this.f36885b.f(), this.f36887d, this.f36888e);
        int i6 = 0;
        boolean zA = true;
        int iCodePointAt = Character.codePointAt(charSequence, i3);
        loop0: while (true) {
            iCharCount = i3;
            while (i3 < i4 && i6 < i5 && zA) {
                int iA = processorSm.a(iCodePointAt);
                if (iA == 1) {
                    iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                    if (iCharCount < i4) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                    i3 = iCharCount;
                } else if (iA == 2) {
                    i3 += Character.charCount(iCodePointAt);
                    if (i3 < i4) {
                        iCodePointAt = Character.codePointAt(charSequence, i3);
                    }
                } else if (iA == 3) {
                    if (z2 || !f(charSequence, iCharCount, i3, processorSm.c())) {
                        zA = emojiProcessCallback.a(charSequence, iCharCount, i3, processorSm.c());
                        i6++;
                    }
                }
            }
            break loop0;
        }
        if (processorSm.e() && i6 < i5 && zA && (z2 || !f(charSequence, iCharCount, i3, processorSm.b()))) {
            emojiProcessCallback.a(charSequence, iCharCount, i3, processorSm.b());
        }
        return emojiProcessCallback.getResult();
    }

    int b(CharSequence charSequence, int i3) {
        if (i3 < 0 || i3 >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i3, i3 + 1, EmojiSpan.class);
            if (emojiSpanArr.length > 0) {
                return spanned.getSpanEnd(emojiSpanArr[0]);
            }
        }
        return ((EmojiProcessLookupCallback) k(charSequence, Math.max(0, i3 - 16), Math.min(charSequence.length(), i3 + 16), Api.BaseClientBuilder.API_PRIORITY_OTHER, true, new EmojiProcessLookupCallback(i3))).f36893c;
    }

    int c(CharSequence charSequence, int i3) {
        if (i3 < 0 || i3 >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i3, i3 + 1, EmojiSpan.class);
            if (emojiSpanArr.length > 0) {
                return spanned.getSpanStart(emojiSpanArr[0]);
            }
        }
        return ((EmojiProcessLookupCallback) k(charSequence, Math.max(0, i3 - 16), Math.min(charSequence.length(), i3 + 16), Api.BaseClientBuilder.API_PRIORITY_OTHER, true, new EmojiProcessLookupCallback(i3))).f36892b;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003c A[Catch: all -> 0x002a, TRY_ENTER, TryCatch #2 {all -> 0x002a, blocks: (B:7:0x000e, B:10:0x0013, B:12:0x0017, B:14:0x0024, B:22:0x003c, B:24:0x0044, B:26:0x0047, B:28:0x004b, B:30:0x0057, B:31:0x005a, B:41:0x0078), top: B:70:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b A[Catch: all -> 0x002a, TryCatch #2 {all -> 0x002a, blocks: (B:7:0x000e, B:10:0x0013, B:12:0x0017, B:14:0x0024, B:22:0x003c, B:24:0x0044, B:26:0x0047, B:28:0x004b, B:30:0x0057, B:31:0x005a, B:41:0x0078), top: B:70:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069 A[Catch: all -> 0x00b0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00b0, blocks: (B:35:0x0069, B:44:0x0085, B:19:0x0031), top: B:66:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.CharSequence j(java.lang.CharSequence r11, int r12, int r13, int r14, boolean r15) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r1 = r11 instanceof androidx.emoji2.text.SpannableBuilder
            if (r1 == 0) goto La
            r0 = r11
            androidx.emoji2.text.SpannableBuilder r0 = (androidx.emoji2.text.SpannableBuilder) r0
            r0.a()
        La:
            java.lang.Class<androidx.emoji2.text.EmojiSpan> r0 = androidx.emoji2.text.EmojiSpan.class
            if (r1 != 0) goto L31
            boolean r2 = r11 instanceof android.text.Spannable     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L13
            goto L31
        L13:
            boolean r2 = r11 instanceof android.text.Spanned     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2f
            r2 = r11
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch: java.lang.Throwable -> L2a
            int r3 = r12 + (-1)
            int r4 = r13 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r0)     // Catch: java.lang.Throwable -> L2a
            if (r2 > r13) goto L2f
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch: java.lang.Throwable -> L2a
            r2.<init>(r11)     // Catch: java.lang.Throwable -> L2a
            goto L39
        L2a:
            r0 = move-exception
            r12 = r0
            r3 = r11
            goto Lba
        L2f:
            r2 = 0
            goto L39
        L31:
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch: java.lang.Throwable -> Lb0
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch: java.lang.Throwable -> Lb0
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb0
        L39:
            r3 = 0
            if (r2 == 0) goto L65
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r0)     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.EmojiSpan[] r4 = (androidx.emoji2.text.EmojiSpan[]) r4     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L65
            int r5 = r4.length     // Catch: java.lang.Throwable -> L2a
            if (r5 <= 0) goto L65
            int r5 = r4.length     // Catch: java.lang.Throwable -> L2a
            r6 = r3
        L49:
            if (r6 >= r5) goto L65
            r7 = r4[r6]     // Catch: java.lang.Throwable -> L2a
            int r8 = r2.getSpanStart(r7)     // Catch: java.lang.Throwable -> L2a
            int r9 = r2.getSpanEnd(r7)     // Catch: java.lang.Throwable -> L2a
            if (r8 == r13) goto L5a
            r2.removeSpan(r7)     // Catch: java.lang.Throwable -> L2a
        L5a:
            int r12 = java.lang.Math.min(r8, r12)     // Catch: java.lang.Throwable -> L2a
            int r13 = java.lang.Math.max(r9, r13)     // Catch: java.lang.Throwable -> L2a
            int r6 = r6 + 1
            goto L49
        L65:
            r4 = r12
            r5 = r13
            if (r4 == r5) goto L6f
            int r12 = r11.length()     // Catch: java.lang.Throwable -> Lb0
            if (r4 < r12) goto L71
        L6f:
            r3 = r11
            goto Lb3
        L71:
            r12 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r12) goto L84
            if (r2 == 0) goto L84
            int r12 = r2.length()     // Catch: java.lang.Throwable -> L2a
            java.lang.Object[] r12 = r2.getSpans(r3, r12, r0)     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.EmojiSpan[] r12 = (androidx.emoji2.text.EmojiSpan[]) r12     // Catch: java.lang.Throwable -> L2a
            int r12 = r12.length     // Catch: java.lang.Throwable -> L2a
            int r14 = r14 - r12
        L84:
            r6 = r14
            androidx.emoji2.text.EmojiProcessor$EmojiProcessAddSpanCallback r8 = new androidx.emoji2.text.EmojiProcessor$EmojiProcessAddSpanCallback     // Catch: java.lang.Throwable -> Lb0
            androidx.emoji2.text.EmojiCompat$SpanFactory r12 = r10.f36884a     // Catch: java.lang.Throwable -> Lb0
            r8.<init>(r2, r12)     // Catch: java.lang.Throwable -> Lb0
            r2 = r10
            r3 = r11
            r7 = r15
            java.lang.Object r11 = r2.k(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La4
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r11 = (androidx.emoji2.text.UnprecomputeTextOnModificationSpannable) r11     // Catch: java.lang.Throwable -> La4
            if (r11 == 0) goto La7
            android.text.Spannable r11 = r11.b()     // Catch: java.lang.Throwable -> La4
            if (r1 == 0) goto La3
            r12 = r3
            androidx.emoji2.text.SpannableBuilder r12 = (androidx.emoji2.text.SpannableBuilder) r12
            r12.d()
        La3:
            return r11
        La4:
            r0 = move-exception
        La5:
            r12 = r0
            goto Lba
        La7:
            if (r1 == 0) goto Laf
            r11 = r3
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
        Lac:
            r11.d()
        Laf:
            return r3
        Lb0:
            r0 = move-exception
            r3 = r11
            goto La5
        Lb3:
            if (r1 == 0) goto Lb9
            r11 = r3
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            goto Lac
        Lb9:
            return r3
        Lba:
            if (r1 == 0) goto Lc2
            r11 = r3
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.d()
        Lc2:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.j(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EmojiProcessLookupCallback implements EmojiProcessCallback<EmojiProcessLookupCallback> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f36892b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f36893c = -1;

        EmojiProcessLookupCallback(int i3) {
            this.f36891a = i3;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean a(CharSequence charSequence, int i3, int i4, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            int i5 = this.f36891a;
            if (i3 > i5 || i5 >= i4) {
                return i4 <= i5;
            }
            this.f36892b = i3;
            this.f36893c = i4;
            return false;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public EmojiProcessLookupCallback getResult() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MarkExclusionCallback implements EmojiProcessCallback<MarkExclusionCallback> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f36894a;

        MarkExclusionCallback(String str) {
            this.f36894a = str;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean a(CharSequence charSequence, int i3, int i4, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (!TextUtils.equals(charSequence.subSequence(i3, i4), this.f36894a)) {
                return true;
            }
            typefaceEmojiRasterizer.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MarkExclusionCallback getResult() {
            return this;
        }
    }
}
