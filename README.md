# TUF-2000M challenge

## Problem description

There is a TUF-2000M energy meter that has a Modbus Interface described in docs/tuf-2000m.pdf

There is a live text feed from a TUF-2000M device that is available on http://tuftuf.gambitlabs.fi/feed.txt that shows the first 100 register values and looks like this:

```
2017-01-11 19:12
1:7579
2:48988
3:5064
4:48142
5:37967
6:48877
7:63814
8:17575
9:0
10:0
11:24224
12:15965
13:0
14:0
15:0
16:0
17:87
18:0
19:9891
20:16221
21:65480
22:65535
23:39041
24:48994
25:0
26:0
27:0
28:0
29:144
30:0
31:48777
32:16191
33:15568
34:16611
35:28424
36:16534
37:7424
38:15783
39:14592
40:15758
41:5461
42:49087
43:45184
44:15493
45:36608
46:15459
47:29184
48:15516
49:0
50:0
51:0
52:0
53:6432
54:4386
55:5889
56:0
57:0
58:0
59:0
60:255
61:120
62:0
63:0
64:0
65:0
66:4001
67:62500
68:0
69:0
70:3
71:4
72:4
73:3606
74:16800
75:54913
76:48896
77:35706
78:17101
79:44042
80:17099
81:33339
82:16963
83:42500
84:49530
85:33468
86:16963
87:33210
88:16963
89:2885
90:16512
91:0
92:806
93:3501
94:3501
95:0
96:1
97:43137
98:17105
99:3374
100:17839
```

To help you on your way with data conversion I will give you a few clues based on the example data above:

- Register 21-22, Negative energy accumulator is -56.
- Register 33-34, Temperature #1/inlet is 7.101173400878906.
- Register 92, Signal Quality is 38.

## Your task

Your task is to create a program that parses the data, converts it to human readable data like integers, decimals and strings and presents it in a nice way. Depending on your skills and interests you can create a web service that will provide the conversion data, or you could even create a UI to visualize the data somehow, it is entirely up to you what you make of it!

Provide your solution as a Git repository preferably online like GitHub, e-mail me the link and describe your solution either in the mail or using the README markdown. If you decide to do a web service I'd love to see it up and running in the cloud. 
