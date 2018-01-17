package nyc.c4q.mustafizurmatin.midtermretake;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LoopActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
        textView = (TextView) findViewById(R.id.loop);
        Task task = new Task(this);
        task.execute(0);
    }



    private class Task extends AsyncTask<Integer, Integer, Integer> {
        private Activity activity;
        public Task(Activity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            //Setup precondition to execute some task
        }

        @Override
        protected Integer doInBackground(Integer[] values) {

            int i;
            for (i = values[0]; i < 100000; i++) {
                publishProgress(i);
            }
            return i;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            textView.setText("Loops completed: " + values[0]);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            textView.setText("Loops completed: " + integer);

            Intent intent = new Intent(LoopActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

}
