import java.util.*;
class Solution {
    class Genre implements Comparable<Genre> {
        String genre;
        int total;
        public Genre(String genre, int total) {
            this.genre = genre;
            this.total = total;
        }
        @Override
        public int compareTo(Genre o) {
            return o.total - this.total;
        }
    }
    
    
    class Song implements Comparable<Song> {
        int index;
        int played;
        public Song(int index, int played) {
            this.index = index;
            this.played = played;
        }
        @Override
        public int compareTo(Song o) {
            return o.played - this.played;
        }
    }
    
    
    public int[] solution(String[] genres, int[] plays) {
        
        //전체 합산
        HashMap<String, Integer> hash = new HashMap<>(); //가장 많은 장르
        HashMap<String, ArrayList<Song>> hashSong = new HashMap<>(); //장르별 음약
        for (int i = 0; i < genres.length; i++) {
            hash.put(genres[i], hash.getOrDefault(genres[i], 0) + plays[i]);
            ArrayList<Song> temp;
            if (hashSong.containsKey(genres[i])) {
                temp = hashSong.get(genres[i]);
            } else {
                temp = new ArrayList<>();
            }
            temp.add(new Song(i, plays[i]));
            hashSong.put(genres[i], temp);
        }
        
        //정렬을 위한 PriorityQueue 선언
        PriorityQueue<Genre> genre_pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : hash.entrySet()) {
            genre_pq.add(new Genre(entry.getKey(), entry.getValue()));
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        //장르를 다 소진할 때 까지
        while (!genre_pq.isEmpty()) {
            Genre gen = genre_pq.poll(); //가장 많이 재생된 장르 수록
            PriorityQueue<Song> song_pq = new PriorityQueue<>();
            for (Song song : hashSong.get(gen.genre)) {
                song_pq.add(song);
            }
            for (int i = 0; i < 2; i++) {
                if (!song_pq.isEmpty()) {
                    answer.add(song_pq.poll().index);
                }
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}