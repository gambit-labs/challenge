# Gambit challenge

## Problem description

TUF-2000M is an ultrasonic energy meter that has a [Modbus](https://en.wikipedia.org/wiki/Modbus) interface described in docs/tuf-2000m.pdf.

Gambit has access to one of these meters and it is providing you a [live text feed](http://tuftuf.gambitlabs.fi/feed.txt) that shows the time of the reading followed by the first 100 register values which look like this:

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

The registers and their respective datatypes are explained in detail in [docs/tuf-2000m.pdf](https://github.com/gambit-labs/tuf-2000m/blob/master/docs/tuf-2000m.pdf) on pages 39-42.

## Your task

Select one task from below. There is no single solution to these problems and we don't expect a complete solution to consider you for a position.

### Option 1: Create an REST API that parses the data to a readable form
- .NET Core or maybe node.js?
- JSON output is greatly appreciated
- Easily deployable and testable
- Authentication

### Option 2: Create UI for showing the data for user
- Modern javascript frameworks or maybe an mobile app. It's up to you
- Easily deployable and testable
- UX will be also a key factor on this
- Authentication

## Presenting your solution

Provide your solution as a Git repository, e-mail me the link to your private repo. 

We appreciate if you can host your solution somewhere in the cloud or VPS so we can see an actual demo of it, rather than just looking at code.

Good use of Git version control is appreciated.