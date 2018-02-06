<!DOCTYPE html>
<html>
<title>JS Basics</title>

<body>
    <script>
        let x = [];
        x.push("coding", "dojo", "rocks");
        x.pop();
        console.log(x);


        const y = [];
        y.push(88);
        console.log(y);

        let z = [9, 10, 6, 5, -1, 20, 13, 2];
        for (var i = 0; i < z.length - 1; i++) {
            console.log(z[i]);
        }

        let names = ['Kadie', 'Joe', 'Fritz', 'Pierre', 'Alphonso'];
        for (var i = 0; i < names.length; i++) {
            if (names[i].length >= 5) {
                console.log(names[i].length)
            }
        }

        function yell(str) {
            return str.toUpperCase();
        }

        console.log(yell("hello"));
    </script>
</body>

</html>