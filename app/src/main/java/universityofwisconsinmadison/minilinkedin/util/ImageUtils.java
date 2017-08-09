package universityofwisconsinmadison.minilinkedin.util;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.widget.ImageView;

public class ImageUtils {

    public static void loadImage(@NonNull Context context, @NonNull Uri uri, @NonNull ImageView imageView) {

        //		Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
        Bitmap bitmap = BitmapFactory.decodeFile(uri.getPath());
        imageView.setImageBitmap(bitmap);

    }

    public static String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
