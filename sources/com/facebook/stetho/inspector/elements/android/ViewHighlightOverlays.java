package com.facebook.stetho.inspector.elements.android;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class ViewHighlightOverlays {
    ViewHighlightOverlays() {
    }

    static ViewHighlightOverlays newInstance() {
        return new ViewHighlightOverlaysJellybeanMR2();
    }

    abstract void highlightView(View view, Rect rect, int i3);

    abstract void removeHighlight(View view);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ViewHighlightOverlaysJellybeanMR2 extends ViewHighlightOverlays {
        private static final int MARGIN_OVERLAY_COLOR = -1426797922;
        private static final int PADDING_OVERLAY_COLOR = -1430332746;
        private final HighlightDrawable[] mHighlightDrawables;
        private final MainHighlightDrawable mMainHighlightDrawable;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class MainHighlightDrawable extends HighlightDrawable {
            MainHighlightDrawable() {
            }

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Rect clipBounds = canvas.getClipBounds();
                Rect rect = this.mMargins;
                clipBounds.inset(-(rect.right + rect.left), -(rect.top + rect.bottom));
                canvas.clipOutRect(clipBounds);
                super.draw(canvas);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class MarginBottomHighlightDrawable extends HighlightDrawable {
            MarginBottomHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Rect rect = this.mMargins;
                canvas.translate(0.0f, rect.bottom + rect.top);
                super.draw(canvas);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, view.getHeight() - this.mMargins.bottom, view.getWidth(), view.getHeight());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class MarginLeftHighlightDrawable extends HighlightDrawable {
            MarginLeftHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Rect rect = this.mMargins;
                canvas.translate(-(rect.left + rect.right), 0.0f);
                super.draw(canvas);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                int i3 = this.mMargins.left;
                int height = view.getHeight();
                Rect rect = this.mMargins;
                setBounds(0, 0, i3, height + rect.top + rect.bottom);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class MarginRightHighlightDrawable extends HighlightDrawable {
            MarginRightHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Rect rect = this.mMargins;
                canvas.translate(rect.right, -(rect.top + rect.bottom));
                super.draw(canvas);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                int width = view.getWidth() - this.mMargins.right;
                int width2 = view.getWidth();
                int height = view.getHeight();
                Rect rect = this.mMargins;
                setBounds(width, 0, width2, height + rect.top + rect.bottom);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class MarginTopHighlightDrawable extends HighlightDrawable {
            MarginTopHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                canvas.translate(0.0f, -this.mMargins.top);
                super.draw(canvas);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, 0, view.getWidth(), this.mMargins.top);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class PaddingBottomHighlightDrawable extends HighlightDrawable {
            PaddingBottomHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                setBounds(this.mPaddings.left, view.getHeight() - this.mPaddings.bottom, view.getWidth() - this.mPaddings.right, view.getHeight());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class PaddingLeftHighlightDrawable extends HighlightDrawable {
            PaddingLeftHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, 0, this.mPaddings.left, view.getHeight());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class PaddingRightHighlightDrawable extends HighlightDrawable {
            PaddingRightHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                setBounds(view.getWidth() - this.mPaddings.right, 0, view.getWidth(), view.getHeight());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class PaddingTopHighlightDrawable extends HighlightDrawable {
            PaddingTopHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays.ViewHighlightOverlaysJellybeanMR2.HighlightDrawable
            void highlightView(View view) {
                super.highlightView(view);
                int i3 = this.mPaddings.left;
                int width = view.getWidth();
                Rect rect = this.mPaddings;
                setBounds(i3, 0, width - rect.right, rect.top);
            }
        }

        ViewHighlightOverlaysJellybeanMR2() {
            MainHighlightDrawable mainHighlightDrawable = new MainHighlightDrawable();
            this.mMainHighlightDrawable = mainHighlightDrawable;
            this.mHighlightDrawables = new HighlightDrawable[]{mainHighlightDrawable, new PaddingTopHighlightDrawable(), new PaddingBottomHighlightDrawable(), new PaddingRightHighlightDrawable(), new PaddingLeftHighlightDrawable(), new MarginTopHighlightDrawable(), new MarginBottomHighlightDrawable(), new MarginRightHighlightDrawable(), new MarginLeftHighlightDrawable()};
        }

        @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays
        void highlightView(View view, Rect rect, int i3) {
            this.mMainHighlightDrawable.setColor(i3);
            if (rect.isEmpty()) {
                this.mMainHighlightDrawable.setBounds(0, 0, view.getWidth(), view.getHeight());
            } else {
                this.mMainHighlightDrawable.setBounds(rect);
            }
            int length = this.mHighlightDrawables.length;
            for (int i4 = 0; i4 < length; i4++) {
                HighlightDrawable highlightDrawable = this.mHighlightDrawables[i4];
                highlightDrawable.highlightView(view);
                view.getOverlay().add(highlightDrawable);
            }
        }

        @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays
        void removeHighlight(View view) {
            for (HighlightDrawable highlightDrawable : this.mHighlightDrawables) {
                view.getOverlay().remove(highlightDrawable);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static abstract class HighlightDrawable extends ColorDrawable {
            protected final Rect mMargins;
            protected final Rect mPaddings;

            HighlightDrawable(int i3) {
                super(i3);
                this.mMargins = new Rect();
                this.mPaddings = new Rect();
            }

            void highlightView(View view) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    Rect rect = this.mMargins;
                    rect.left = marginLayoutParams.leftMargin;
                    rect.top = marginLayoutParams.topMargin;
                    rect.right = marginLayoutParams.rightMargin;
                    rect.bottom = marginLayoutParams.bottomMargin;
                } else {
                    Rect rect2 = this.mMargins;
                    rect2.left = 0;
                    rect2.top = 0;
                    rect2.right = 0;
                    rect2.bottom = 0;
                }
                this.mPaddings.left = view.getPaddingLeft();
                this.mPaddings.top = view.getPaddingTop();
                this.mPaddings.right = view.getPaddingRight();
                this.mPaddings.bottom = view.getPaddingBottom();
            }

            public HighlightDrawable() {
                this.mMargins = new Rect();
                this.mPaddings = new Rect();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NoOpViewHighlightOverlays extends ViewHighlightOverlays {
        private NoOpViewHighlightOverlays() {
        }

        @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays
        void removeHighlight(View view) {
        }

        @Override // com.facebook.stetho.inspector.elements.android.ViewHighlightOverlays
        void highlightView(View view, Rect rect, int i3) {
        }
    }
}
