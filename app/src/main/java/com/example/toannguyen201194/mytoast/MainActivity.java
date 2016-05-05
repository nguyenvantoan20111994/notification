package com.example.toannguyen201194.mytoast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnnoca;
    NotificationManager notificationManager;
    int notificationnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnnoca= (Button) findViewById(R.id.btnnoca);
        btnnoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupnotification();
            }

        });
    }
    private void setupnotification(){
        // tao notificationcompat set cac title,text,
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setContentTitle("New Message");
        builder.setContentText("Hien thi nó lên nào");
        builder.setSmallIcon(R.drawable.iconnotifi);
        builder.setNumber(notificationnumber++);
        // tao mot intent nham khhoi tao activity khi nguoi dung click vao notification
        Intent intent=new Intent(getApplicationContext(),mainshow_layout.class);
        TaskStackBuilder  taskStackBuilder=TaskStackBuilder.create(this);
        // su dung stask nham dieu huong activity ve man hinh chính
        taskStackBuilder.addParentStack(mainshow_layout.class);
        taskStackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent=taskStackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(100,builder.build());
        finish();

    }
}
