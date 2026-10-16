package com.caverock.androidsvg;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SVGImageView extends ImageView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f67694c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SVG f67695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RenderOptions f67696b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class LoadResourceTask extends AsyncTask<Integer, Integer, SVG> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f67697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f67698b;

        LoadResourceTask(Context context, int i3) {
            this.f67697a = context;
            this.f67698b = i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SVG doInBackground(Integer... numArr) {
            try {
                return SVG.m(this.f67697a, this.f67698b);
            } catch (SVGParseException e3) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(this.f67698b), e3.getMessage()));
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(SVG svg) {
            SVGImageView.this.f67695a = svg;
            SVGImageView.this.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class LoadURITask extends AsyncTask<InputStream, Integer, SVG> {
        private LoadURITask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SVG doInBackground(InputStream... inputStreamArr) {
            try {
                try {
                    return SVG.l(inputStreamArr[0]);
                } catch (SVGParseException e3) {
                    Log.e("SVGImageView", "Parse error loading URI: " + e3.getMessage());
                    try {
                        inputStreamArr[0].close();
                        return null;
                    } catch (IOException unused) {
                        return null;
                    }
                }
            } finally {
                try {
                    inputStreamArr[0].close();
                } catch (IOException unused2) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(SVG svg) {
            SVGImageView.this.f67695a = svg;
            SVGImageView.this.c();
        }
    }

    static {
        try {
            f67694c = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        SVG svg = this.f67695a;
        if (svg == null) {
            return;
        }
        Picture pictureU = svg.u(this.f67696b);
        f();
        setImageDrawable(new PictureDrawable(pictureU));
    }

    private boolean d(String str) {
        try {
            new LoadURITask().execute(getContext().getAssets().open(str));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private boolean e(Uri uri) {
        try {
            new LoadURITask().execute(getContext().getContentResolver().openInputStream(uri));
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    private void f() {
        if (f67694c == null) {
            return;
        }
        try {
            f67694c.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
        } catch (Exception e3) {
            Log.w("SVGImageView", "Unexpected failure calling setLayerType", e3);
        }
    }

    private void setFromString(String str) {
        try {
            this.f67695a = SVG.o(str);
            c();
        } catch (SVGParseException unused) {
            Log.e("SVGImageView", "Could not find SVG at: " + str);
        }
    }

    public void setCSS(String str) {
        this.f67696b.a(str);
        c();
    }

    public void setImageAsset(String str) {
        if (d(str)) {
            return;
        }
        Log.e("SVGImageView", "File not found: " + str);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        new LoadResourceTask(getContext(), i3).execute(new Integer[0]);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (e(uri)) {
            return;
        }
        Log.e("SVGImageView", "File not found: " + uri);
    }

    public void setSVG(SVG svg) {
        if (svg == null) {
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
        this.f67695a = svg;
        c();
    }
}
