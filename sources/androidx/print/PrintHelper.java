package androidx.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PrintHelper {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final boolean f51072e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final boolean f51073f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f51074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    BitmapFactory.Options f51075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f51076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f51077d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnPrintFinishCallback {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PrintBitmapAdapter extends PrintDocumentAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f51086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f51087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Bitmap f51088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final OnPrintFinishCallback f51089d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private PrintAttributes f51090e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ PrintHelper f51091f;

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.f51089d;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.a();
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.f51090e = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f51086a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.f51091f.g(this.f51090e, this.f51087b, this.f51088c, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PrintUriAdapter extends PrintDocumentAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f51092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Uri f51093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final OnPrintFinishCallback f51094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f51095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        PrintAttributes f51096e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        AsyncTask f51097f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Bitmap f51098g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ PrintHelper f51099h;

        void a() {
            synchronized (this.f51099h.f51076c) {
                try {
                    PrintHelper printHelper = this.f51099h;
                    if (printHelper.f51075b != null) {
                        printHelper.f51075b = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            a();
            AsyncTask asyncTask = this.f51097f;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.f51094c;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.a();
            }
            Bitmap bitmap = this.f51098g;
            if (bitmap != null) {
                bitmap.recycle();
                this.f51098g = null;
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(final PrintAttributes printAttributes, final PrintAttributes printAttributes2, final CancellationSignal cancellationSignal, final PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) throws Throwable {
            synchronized (this) {
                try {
                    this.f51096e = printAttributes2;
                } catch (Throwable th) {
                    th = th;
                    while (true) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.f51098g != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f51092a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                this.f51097f = new AsyncTask<Uri, Boolean, Bitmap>() { // from class: androidx.print.PrintHelper.PrintUriAdapter.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Bitmap doInBackground(Uri... uriArr) {
                        try {
                            PrintUriAdapter printUriAdapter = PrintUriAdapter.this;
                            return printUriAdapter.f51099h.f(printUriAdapter.f51093b);
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public void onCancelled(Bitmap bitmap) {
                        layoutResultCallback.onLayoutCancelled();
                        PrintUriAdapter.this.f51097f = null;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
                    @Override // android.os.AsyncTask
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onPostExecute(android.graphics.Bitmap r10) {
                        /*
                            r9 = this;
                            super.onPostExecute(r10)
                            if (r10 == 0) goto L12
                            boolean r0 = androidx.print.PrintHelper.f51072e
                            if (r0 == 0) goto L14
                            androidx.print.PrintHelper$PrintUriAdapter r0 = androidx.print.PrintHelper.PrintUriAdapter.this
                            androidx.print.PrintHelper r0 = r0.f51099h
                            int r0 = r0.f51077d
                            if (r0 != 0) goto L12
                            goto L14
                        L12:
                            r2 = r10
                            goto L49
                        L14:
                            monitor-enter(r9)
                            androidx.print.PrintHelper$PrintUriAdapter r0 = androidx.print.PrintHelper.PrintUriAdapter.this     // Catch: java.lang.Throwable -> L45
                            android.print.PrintAttributes r0 = r0.f51096e     // Catch: java.lang.Throwable -> L45
                            android.print.PrintAttributes$MediaSize r0 = r0.getMediaSize()     // Catch: java.lang.Throwable -> L45
                            monitor-exit(r9)     // Catch: java.lang.Throwable -> L45
                            if (r0 == 0) goto L12
                            boolean r0 = r0.isPortrait()
                            boolean r1 = androidx.print.PrintHelper.d(r10)
                            if (r0 == r1) goto L12
                            android.graphics.Matrix r7 = new android.graphics.Matrix
                            r7.<init>()
                            r0 = 1119092736(0x42b40000, float:90.0)
                            r7.postRotate(r0)
                            int r5 = r10.getWidth()
                            int r6 = r10.getHeight()
                            r8 = 1
                            r3 = 0
                            r4 = 0
                            r2 = r10
                            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)
                            goto L4a
                        L45:
                            r0 = move-exception
                            r10 = r0
                            monitor-exit(r9)     // Catch: java.lang.Throwable -> L45
                            throw r10
                        L49:
                            r10 = r2
                        L4a:
                            androidx.print.PrintHelper$PrintUriAdapter r0 = androidx.print.PrintHelper.PrintUriAdapter.this
                            r0.f51098g = r10
                            r0 = 0
                            if (r10 == 0) goto L76
                            android.print.PrintDocumentInfo$Builder r10 = new android.print.PrintDocumentInfo$Builder
                            androidx.print.PrintHelper$PrintUriAdapter r1 = androidx.print.PrintHelper.PrintUriAdapter.this
                            java.lang.String r1 = r1.f51092a
                            r10.<init>(r1)
                            r1 = 1
                            android.print.PrintDocumentInfo$Builder r10 = r10.setContentType(r1)
                            android.print.PrintDocumentInfo$Builder r10 = r10.setPageCount(r1)
                            android.print.PrintDocumentInfo r10 = r10.build()
                            android.print.PrintAttributes r2 = r3
                            android.print.PrintAttributes r3 = r4
                            boolean r2 = r2.equals(r3)
                            r1 = r1 ^ r2
                            android.print.PrintDocumentAdapter$LayoutResultCallback r2 = r5
                            r2.onLayoutFinished(r10, r1)
                            goto L7b
                        L76:
                            android.print.PrintDocumentAdapter$LayoutResultCallback r10 = r5
                            r10.onLayoutFailed(r0)
                        L7b:
                            androidx.print.PrintHelper$PrintUriAdapter r10 = androidx.print.PrintHelper.PrintUriAdapter.this
                            r10.f51097f = r0
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.PrintUriAdapter.AnonymousClass1.onPostExecute(android.graphics.Bitmap):void");
                    }

                    @Override // android.os.AsyncTask
                    protected void onPreExecute() {
                        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.print.PrintHelper.PrintUriAdapter.1.1
                            @Override // android.os.CancellationSignal.OnCancelListener
                            public void onCancel() {
                                PrintUriAdapter.this.a();
                                cancel(false);
                            }
                        });
                    }
                }.execute(new Uri[0]);
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.f51099h.g(this.f51096e, this.f51095d, this.f51098g, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static Bitmap a(Bitmap bitmap, int i3) {
        if (i3 != 1) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    private static PrintAttributes.Builder b(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (printAttributes.getDuplexMode() != 0) {
            minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    static Matrix c(int i3, int i4, RectF rectF, int i5) {
        Matrix matrix = new Matrix();
        float f3 = i3;
        float fWidth = rectF.width() / f3;
        float fMax = i5 == 2 ? Math.max(fWidth, rectF.height() / i4) : Math.min(fWidth, rectF.height() / i4);
        matrix.postScale(fMax, fMax);
        matrix.postTranslate((rectF.width() - (f3 * fMax)) / 2.0f, (rectF.height() - (i4 * fMax)) / 2.0f);
        return matrix;
    }

    static boolean d(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    private Bitmap e(Uri uri, BitmapFactory.Options options) throws Throwable {
        Context context;
        if (uri == null || (context = this.f51074a) == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                        return bitmapDecodeStream;
                    } catch (IOException e3) {
                        Log.w("PrintHelper", "close fail ", e3);
                    }
                }
                return bitmapDecodeStream;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        Log.w("PrintHelper", "close fail ", e4);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    Bitmap f(Uri uri) throws Throwable {
        BitmapFactory.Options options;
        if (uri == null || this.f51074a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        e(uri, options2);
        int i3 = options2.outWidth;
        int i4 = options2.outHeight;
        if (i3 > 0 && i4 > 0) {
            int iMax = Math.max(i3, i4);
            int i5 = 1;
            while (iMax > 3500) {
                iMax >>>= 1;
                i5 <<= 1;
            }
            if (i5 > 0 && Math.min(i3, i4) / i5 > 0) {
                synchronized (this.f51076c) {
                    options = new BitmapFactory.Options();
                    this.f51075b = options;
                    options.inMutable = true;
                    options.inSampleSize = i5;
                }
                try {
                    Bitmap bitmapE = e(uri, options);
                    synchronized (this.f51076c) {
                        this.f51075b = null;
                    }
                    return bitmapE;
                } catch (Throwable th) {
                    synchronized (this.f51076c) {
                        this.f51075b = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    void g(final PrintAttributes printAttributes, final int i3, final Bitmap bitmap, final ParcelFileDescriptor parcelFileDescriptor, final CancellationSignal cancellationSignal, final PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        final PrintAttributes printAttributesBuild = f51073f ? printAttributes : b(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        new AsyncTask<Void, Void, Throwable>() { // from class: androidx.print.PrintHelper.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Throwable doInBackground(Void... voidArr) {
                RectF rectF;
                try {
                    if (cancellationSignal.isCanceled()) {
                        return null;
                    }
                    PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelper.this.f51074a, printAttributesBuild);
                    Bitmap bitmapA = PrintHelper.a(bitmap, printAttributesBuild.getColorMode());
                    if (cancellationSignal.isCanceled()) {
                        return null;
                    }
                    try {
                        PdfDocument.Page pageStartPage = printedPdfDocument.startPage(1);
                        boolean z2 = PrintHelper.f51073f;
                        if (z2) {
                            rectF = new RectF(pageStartPage.getInfo().getContentRect());
                        } else {
                            PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(PrintHelper.this.f51074a, printAttributes);
                            PdfDocument.Page pageStartPage2 = printedPdfDocument2.startPage(1);
                            RectF rectF2 = new RectF(pageStartPage2.getInfo().getContentRect());
                            printedPdfDocument2.finishPage(pageStartPage2);
                            printedPdfDocument2.close();
                            rectF = rectF2;
                        }
                        Matrix matrixC = PrintHelper.c(bitmapA.getWidth(), bitmapA.getHeight(), rectF, i3);
                        if (!z2) {
                            matrixC.postTranslate(rectF.left, rectF.top);
                            pageStartPage.getCanvas().clipRect(rectF);
                        }
                        pageStartPage.getCanvas().drawBitmap(bitmapA, matrixC, null);
                        printedPdfDocument.finishPage(pageStartPage);
                        if (cancellationSignal.isCanceled()) {
                            printedPdfDocument.close();
                            ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
                            if (parcelFileDescriptor2 != null) {
                                try {
                                    parcelFileDescriptor2.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (bitmapA != bitmap) {
                                bitmapA.recycle();
                            }
                            return null;
                        }
                        printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                        printedPdfDocument.close();
                        ParcelFileDescriptor parcelFileDescriptor3 = parcelFileDescriptor;
                        if (parcelFileDescriptor3 != null) {
                            try {
                                parcelFileDescriptor3.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (bitmapA != bitmap) {
                            bitmapA.recycle();
                        }
                        return null;
                    } finally {
                    }
                } catch (Throwable th) {
                    return th;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Throwable th) {
                if (cancellationSignal.isCanceled()) {
                    writeResultCallback.onWriteCancelled();
                } else if (th == null) {
                    writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } else {
                    Log.e("PrintHelper", "Error writing printed content", th);
                    writeResultCallback.onWriteFailed(null);
                }
            }
        }.execute(new Void[0]);
    }
}
