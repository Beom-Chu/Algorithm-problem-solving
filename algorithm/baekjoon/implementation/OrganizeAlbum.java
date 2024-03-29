/*
앨범정리[20541]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	502	105	79	22.191%
문제
지혜는 컴퓨터에 있는 사진들을 정리하기 위해 앨범정리 프로그램을 만들었다.
지혜가 만든  앨범정리 프로그램은 기본적으로 "album" 앨범이 존재하며 "album" 앨범은 절대로 삭제할 수 없다.
프로그램을 실행시키면 "album" 앨범부터 시작하여 명령어들을 통해 앨범 삭제/추가, 사진 삭제/추가, 현재앨범 이동 등을 할 수 있다.
앨범정리 프로그램은 다음과 같은 명령어 들로 구성 되어 있다.
수행할 명령어의 개수 $N$이 주어질 때 각 명령어 수행 후 문자열 출력이 필요한 명령어에 대해서 문자열을 출력한다.

mkalb
명령어 수행후: 현재 앨범에 속해있는 앨범 중 동일한 이름을 가진 앨범이 존재하여 앨범이 생성되지 않았으면 "duplicated album name"을 출력합니다.
그렇지 않다면 아무것도 출력하지 않습니다.
mkalb $S$
현재 앨범에 $S$ 의 이름을 가진 앨범을 생성합니다.
현재 앨범에 속해있는 앨범 중 동일한 이름을 가진 앨범이 존재하면 앨범을 생성하지 않습니다.
rmalb
명령어 수행후: 삭제된 앨범의 개수와 사진의 개수를 공백으로 구분하여 출력합니다.
rmalb $S$
현재 앨범에 속해있는 앨범 중 $S$ 의 이름을 가진 앨범이 존재한다면, 해당 앨범을 삭제합니다.
삭제된 앨범에 속한 모든 앨범과 사진들 또한 삭제됩니다.
rmalb -1
현재 앨범에 속해있는 앨범이 존재한다면, 이름이 사전순으로 가장 빠른 앨범을 삭제 합니다.
삭제된 앨범에 속한 모든 앨범과 사진들 또한 삭제됩니다.
rmalb 0
현재 앨범에 속해있는 모든 앨범을 삭제 합니다.
삭제된 앨범에 속한 모든 앨범과 사진들 또한 삭제됩니다.
rmalb 1
현재 앨범에 속해있는 앨범이 존재한다면, 이름이 사전순으로 가장 늦은 앨범을 삭제 합니다.
삭제된 앨범에 속한 모든 앨범과 사진들 또한 삭제됩니다.
insert
명령어 수행후: 현재 앨범에 속해있는 사진 중에 동일한 이름을 가진 사진이 존재하여 사진이 삽입되지 않았으면 "duplicated photo name"을 출력합니다.
그렇지 않다면 아무것도 출력하지 않습니다.
insert $S$
현재 앨범에 $S$ 의 이름을 가진 사진을 삽입합니다.
현재 앨범에 속해있는 사진 중 동일한 이름을 가진 사진이 존재하면 사진을 삽입하지 않습니다.
delete
명령어 수행후: 삭제된 사진의 개수를 출력합니다.
delete $S$
현재 앨범에 속해있는 사진 중 $S$ 의 이름을 가진 사진이 존재한다면, 해당 사진을 삭제합니다.
delete -1
현재 앨범에 속해있는 사진이 존재한다면, 이름이 사전순으로 가장 빠른 사진을 삭제 합니다.
delete 0
현재 앨범에 속해있는 모든 사진을 삭제합니다.
delete 1
현재 앨범에 속해있는 사진이 존재한다면, 이름이 사전순으로 가장 늦은 사진을 삭제 합니다.
ca
명령어 수행후: 현재 앨범 이름을 출력합니다.
ca $S$
현재 앨범에 속해있는 앨범 중 $S$ 의 이름을 가진 앨범으로 이동합니다.
현재 앨범에 속해있는 앨범 중 $S$ 의 이름을 가진 앨범이 없다면 현재 앨범에 머무릅니다.
ca ..
현재 앨범의 상위 앨범으로 이동합니다.
현재 앨범이 최상위 앨범인 "album" 앨범이라면 현재 앨범에 머무릅니다.
ca /
최상위 앨범인 "album" 앨범으로 이동합니다.
"A가 B에 속해있다"라는 것은 A의 바로 하위에 B가 있다는 것을 의미합니다.
만약 A가 B에 속해있고, B가 C에 속해있는 경우, A는 C에 속해 있는 것이 아닙니다.

입력
첫째 줄에 수행할 명령어의 개수 $N$이 주어진다.

다음줄 부터 $N$줄에 걸쳐 앨범정리 프로그램의 명령어가 주어진다.

출력
문제 본문에 나와있는 앨범정리 프로그램 명령어의 설명에 따라 적절한 문자열을 출력한다.

제한
1 ≤ $N$ ≤ 105
1 ≤ $S$의 길이 ≤ 20
 $S$는 공백을 포함하지 않은 알파벳 소문자로만 이루어져 있다.
예제 입력 1
24
mkalb animal
mkalb insect
ca animal
mkalb sky
mkalb land
mkalb ocean
ca land
insert elephant
insert tiger
insert banana
delete banana
ca elephant
ca ..
ca ocean
insert whale
ca /
ca insect
mkalb land
mkalb sky
ca ocean
ca ..
ca ..
rmalb -1
rmalb -1
예제 출력 1
animal
land
1
land
animal
ocean
album
insect
insect
album
album
4 3
3 0
예제 입력 2
29
mkalb domestic
mkalb ovarseas
ca domestic
ca incheon
mkalb incheon
ca incheon
mkalb chinatown
mkalb wolmido
ca chinatown
insert jajangmyeon
insert champon
insert friedrice
insert jajangmyeon
ca /
ca domestic
rmalb incheon
ca /
rmalb ovarseas
mkalb overseas
ca overseas
mkalb japanese
mkalb europe
rmalb japanese
ca europe
rmalb 0
ca ..
delete europe
ca ..
rmalb 1
예제 출력 2
domestic
domestic
incheon
chinatown
duplicated photo name
album
domestic
3 3
album
1 0
overseas
1 0
europe
0 0
overseas
0
album
2 0
예제 입력 3
30
mkalb univ
mkalb middle
mkalb elementary
insert middle
ca middle
insert middleschool
ca ..
rmalb middle
ca univ
mkalb inha
insert kaist
insert harvard
delete harvard
ca inha
mkalb inkyungho
mkalb hightech
mkalb jungseok
delete 0
rmalb 1
ca jungseok
ca hightech
mkalb computer
mkalb elect
mkalb machine
rmalb 1
rmalb 1
insert computer
insert elect
ca /
rmalb 0
예제 출력 3
middle
album
1 1
univ
1
inha
0
1 0
inha
hightech
1 0
1 0
album
6 3
 */
package algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class OrganizeAlbum {

    static Integer removeAlbCnt, removePhoCnt;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[][] commands = new String[N][2];
        for (int i = 0; i < N; i++) {
            commands[i] = reader.readLine().split(" ");
        }

        TreeMap<Path, LinkedList<String>> albums = new TreeMap<>();
        Path current = setRoot();
        albums.put(current, new LinkedList<>());

        for(String[] command : commands) {

            if(Objects.equals(command[0], "mkalb")) {

                Optional<Map.Entry<Path, LinkedList<String>>> optSameAlbum = checkExistsAlbum(albums, current, command[1]);
                if(optSameAlbum.isPresent()) {
                    System.out.println("duplicated album name");
                } else {
                    albums.put(current.resolve(command[1]), new LinkedList<>());
                }

            } else if(Objects.equals(command[0], "rmalb")){

                removeAlbCnt = 0;
                removePhoCnt = 0;
                TreeMap<Path, LinkedList<String>> subAlbums = findSubAlbums(albums, current);

                if(!subAlbums.isEmpty()) {
                    if (Objects.equals(command[1], "-1")) {
                        removeAlbum(albums, subAlbums.firstKey());
                    } else if (Objects.equals(command[1], "0")) {
                        for (Map.Entry<Path, LinkedList<String>> e : subAlbums.entrySet()) {
                            removeAlbum(albums, e.getKey());
                        }
                    } else if (Objects.equals(command[1], "1")) {
                        removeAlbum(albums, subAlbums.lastKey());
                    } else {
                        removeAlbum(albums, current.resolve(command[1]));
                    }
                }

                System.out.println(removeAlbCnt + " " + removePhoCnt);

            } else if(Objects.equals(command[0], "insert")){
                List<String> currentAlbum = albums.get(current);
                if(currentAlbum.contains(command[1])) {
                    System.out.println("duplicated photo name");
                } else {
                    currentAlbum.add(command[1]);
                }

            } else if(Objects.equals(command[0], "delete")){
                Integer deletePhoCnt = 0;
                LinkedList<String> photos = albums.get(current);

                if(photos.size() > 0) {
                    if (Objects.equals(command[1], "-1")) {
                        photos.sort(Comparator.naturalOrder());
                        photos.removeFirst();
                        deletePhoCnt++;
                    } else if (Objects.equals(command[1], "0")) {
                        deletePhoCnt += photos.size();
                        photos.clear();
                    } else if (Objects.equals(command[1], "1")) {
                        photos.sort(Comparator.naturalOrder());
                        photos.removeLast();
                        deletePhoCnt++;
                    } else {
                        if(photos.remove(command[1])) {
                            deletePhoCnt++;
                        }
                    }
                }
                System.out.println(deletePhoCnt);

            } else if(Objects.equals(command[0], "ca")){
                if(Objects.equals(command[1], "..")) {
                    if(current.getParent() != null) {
                        current = current.getParent();
                    }
                } else if(Objects.equals(command[1], "/")) {
                    current = setRoot();
                } else {
                    Optional<Map.Entry<Path, LinkedList<String>>> optExistsAlbum = checkExistsAlbum(albums, current, command[1]);
                    if(optExistsAlbum.isPresent()) {
                        current = optExistsAlbum.get().getKey();
                    }
                }
                System.out.println(current.getFileName());
            }
        }
    }

    /** Root 설정 */
    private static Path setRoot() {
        return Path.of("album");
    }

    /** 앨범 삭제 */
    private static void removeAlbum(TreeMap<Path, LinkedList<String>> albums, Path key) {
        // 삭제 대상 앨범의 하위 앨범 모두 찾기
        Map<Path, LinkedList<String>> rmAlbums = albums.entrySet().stream()
                .filter(o -> o.getKey().startsWith(key))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for(Map.Entry<Path, LinkedList<String>> e : rmAlbums.entrySet()) {
            removeAlbCnt++;
            removePhoCnt += e.getValue().size();
            albums.remove(e.getKey());
        }
    }

    /** 앨범 존재 여부 확인 */
    private static Optional<Map.Entry<Path, LinkedList<String>>> checkExistsAlbum(Map<Path, LinkedList<String>> albums, Path current, String albumName) {
        return albums.entrySet().stream()
                .filter(o -> o.getKey().equals(current.resolve(albumName)))
                .findAny();
    }

    /** 하위 앨범 찾기 (하위 중 최상위 앨범들만) */
    private static TreeMap<Path, LinkedList<String>> findSubAlbums(TreeMap<Path, LinkedList<String>> albums, Path current) {
        // 하위 앨범 중 최상위 Depth 구하기
        Integer minNameCnt = albums.entrySet().stream()
                .filter(o -> o.getKey().startsWith(current) && !o.getKey().equals(current))
                .min(Comparator.comparingInt(o -> o.getKey().getNameCount()))
                .map(o -> o.getKey().getNameCount())
                .orElse(0);
        return albums.entrySet().stream()
                .filter(o -> o.getKey().startsWith(current) && !o.getKey().equals(current) && o.getKey().getNameCount() == minNameCnt)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1,o2)->o1, TreeMap::new));
    }
}
